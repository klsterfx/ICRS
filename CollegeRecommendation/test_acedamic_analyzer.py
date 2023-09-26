import warnings

import pandas as pd
import joblib
from sklearn.preprocessing import LabelEncoder

warnings.filterwarnings('ignore')


def data_preprocessing(data_dict, category_list):
    for feature in category_list:
        data_dict[feature] = pd.Categorical(data_dict[feature]).codes
    return data_dict


def perform_college_prediction(data_frame):
    x_test = data_frame.values
    model_dump = joblib.load(r"C:\Users\kushj\Desktop\CollegeRecommendation\base\static\CollegeModel.sav")
    prediction = model_dump.predict(x_test)

    # Inverse transform the numeric labels to get the original string labels
    # label_encoder = LabelEncoder()
    # label_encoder.fit_transform(acedamic_dataframe['CollegeName'])
    prediction = label_encoder.inverse_transform(prediction)
    return {'prediction': prediction}


acedamic_dataframe = pd.read_excel(r"C:\Users\kushj\Desktop\CollegeRecommendation\dataset\AcademicAnalyzerDataset.xlsx")
acedamic_dataframe = acedamic_dataframe.drop('BranchSeat', axis=1)

label_encoder = LabelEncoder()
y = label_encoder.fit_transform(acedamic_dataframe['CollegeName'])
category_list = ['degreeName', 'courseName', 'scholarships', 'collegeType',
                 'entranceExam',
                 'library', 'sportComplex']

X = {'degreeName': 'B.Tech', 'courseName': 'Bio-Medical', 'tutionFeesRange': 150, 'year': 2023,
     'meritRank': 7878, 'scholarships': 'Available', 'collegeType': 'Private', 'entranceExam': 'Mandatory',
     'city': 4, 'placementPercentage': 89, 'library': 'Available', 'sportComplex': 'Available'}
academic_dict = data_preprocessing(X, category_list)
academic_df = pd.DataFrame.from_dict(academic_dict)
print(academic_df)
print(academic_df.shape)
prediction = perform_college_prediction(academic_df)
print(prediction)



