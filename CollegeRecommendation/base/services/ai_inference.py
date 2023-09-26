import warnings

import joblib
import pandas as pd
from sklearn.preprocessing import LabelEncoder

warnings.filterwarnings('ignore')


def data_preprocessing(data_frame, category_list):
    for feature in category_list:
        data_frame[feature] = pd.Categorical(data_frame[feature]).codes
    return data_frame


def perform_college_prediction(data_frame):
    model_dump = joblib.load(r"C:\Users\kushj\Desktop\CollegeRecommendation\base\static\CollegeModel.sav")
    prediction = model_dump.predict(data_frame)
    acedamic_dataframe = pd.read_excel(
        r"C:\Users\kushj\Desktop\CollegeRecommendation\dataset\AcademicAnalyzerDataset.xlsx")
    acedamic_dataframe = acedamic_dataframe.drop('BranchSeat', axis=1)
    label_encoder = LabelEncoder()
    y = label_encoder.fit_transform(acedamic_dataframe['CollegeName'])
    prediction = label_encoder.inverse_transform(prediction)
    return prediction


def ai_call(user_data_dict):
    prediction = ""
    category_list = ['degreeName', 'courseName', 'scholarships', 'collegeType',
                     'entranceExam',
                     'library', 'sportComplex']
    academic_dict = data_preprocessing(user_data_dict, category_list)
    academic_df = pd.DataFrame.from_dict(academic_dict)
    prediction = perform_college_prediction(academic_df)

    if prediction:
        prediction = prediction[0]
    return prediction
