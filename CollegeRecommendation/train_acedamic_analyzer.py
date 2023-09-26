import warnings

import numpy as np
import pandas as pd
from sklearn.ensemble import RandomForestClassifier
import joblib
from sklearn.metrics import mean_absolute_error
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import LabelEncoder

warnings.filterwarnings('ignore')

acedamic_dataframe = pd.read_excel('dataset/AcademicAnalyzerDataset.xlsx')
acedamic_dataframe = acedamic_dataframe.drop('BranchSeat', axis=1)

label_encoder = LabelEncoder()
y = label_encoder.fit_transform(acedamic_dataframe['CollegeName'])
X = acedamic_dataframe.drop(['CollegeName'], axis=1)
category_list = ['degreeName', 'courseName', 'scholarships', 'collegeType',
                     'entranceExam',
                     'library', 'sportComplex']
for feature in category_list:
    X[feature] = pd.Categorical(X[feature]).codes
    print("X[feature]=", X[feature])

X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.20)
X_train = X_train.values
X_test = X_test.values
y_train = np.array(y_train.reshape(-1, 1))
y_test = np.array(y_test.reshape(-1, 1))

print("X_train=", X_train.shape, type(X_train))
print("X_test=", X_test.shape, type(X_test))
print("y_train=", y_train.shape, type(y_train))
print("y_test=", y_test.shape, type(y_test))

Classifier = RandomForestClassifier()
Classifier.fit(X_train, y_train)

filename = 'CollegeModel.sav'

joblib.dump(Classifier, filename)
predicted_y = Classifier.predict(X_test)
print('predicted_y>>>>>', predicted_y)
print("MAE: %.4f" % mean_absolute_error(y_test, predicted_y))
accuracy = Classifier.score(X_test, y_test)
print('Accuracy::', accuracy)

original_college_list = [label_encoder.inverse_transform(i) for i in y_test]
predicted_college_list = [label_encoder.inverse_transform([i]) for i in predicted_y]
column_name = ['Original_College', 'Predicted_College']
df1 = pd.DataFrame({'Original_College': original_college_list, 'Predicted_College': predicted_college_list},
                   columns=column_name)
df1.to_excel('dataset/train_Result.xlsx')
