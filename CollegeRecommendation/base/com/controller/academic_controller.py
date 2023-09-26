from flask import request, jsonify

from base import app
from base.services.ai_inference import ai_call
import pymysql

db_connect = pymysql.connect(user="root", password="root", port=3306, cursorclass=pymysql.cursors.DictCursor,
                             host="localhost", database="icrsdb")


@app.route("/predict", methods=['POST'])
def home():
    prediction_id = request.form.get("predictionId")
    degree_name = request.form.get("degreeName")
    course_name = request.form.get("courseName")
    fees = int(request.form.get("tutionFeesRange"))
    year = int(request.form.get("year"))
    merit_rank = int(request.form.get("meritRank"))
    scholarship = request.form.get("scholarships")`
    college_type = request.form.get("collegeType")
    entrance_exam_accepted = request.form.get("entranceExam")
    city = int(request.form.get("city"))
    placement_percentage = int(request.form.get("placementPercentage"))
    library = request.form.get("library")
    sports_complex = request.form.get("sportComplex")

    data_dict = {"degreeName": degree_name, "courseName": course_name,
                 "tutionFeesRange": fees, "year": year, "meritRank": merit_rank,
                 "scholarships": scholarship, "collegeType": college_type,
                 "entranceExam": entrance_exam_accepted, "city": city,
                 "placementPercentage": placement_percentage,
                 "library": library, "sportComplex": sports_complex}
    print(">>>>>>>>>>>>>>>>>>>>>>", data_dict)

    college_name = ai_call(data_dict)
    print(college_name)
    mycursor = db_connect.cursor()
    mycursor.execute("insert into predicted_college(predicted_college,college_prediction_id)VALUES('{}','{}')".format(college_name,prediction_id))
    # mycursor.execute("ALTER TABLE predicted_college ADD CONSTRAINT college_prediction_id FOREIGN KEY (college_prediction_id) REFERENCES prediction_data_table(prediction_id)")
    # mycursor.execute("ALTER TABLE predicted_college ADD FOREIGN KEY (college_prediction_id) REFERENCES prediction_data_table(prediction_id)")
    db_connect.commit()
    mycursor.close()
    return college_name


# ALTER TABLE Table_Name1 ADD CONSTRAINT ForeignKey_Name FOREIGN KEY (Column_Name) REFERENCES Table_Name2 (Column_Name);
# ALTER TABLE `katalog` ADD FOREIGN KEY (`Sprache` ) REFERENCES `sprache` (`ID` )