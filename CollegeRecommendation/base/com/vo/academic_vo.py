from base import db


class AcademicAnalyzerDatasetVO(db.Model):
    __tablename__ = 'ICRS_table'
    registration_id = db.Column('registration_id', db.Integer,
                                autoincrement=True, primary_key=True)
    College_Name = db.Column('College_Name', db.String(255), nullable=False)
    Degree_Name = db.Column('Degree_Name', db.String(255), nullable=False)
    Course_Name = db.Column('Course_Name', db.String(255), nullable=False)
    Branch_Seat = db.Column('Branch_Seat', db.Integer, nullable=False)
    Fees = db.Column('Fees', db.Integer, nullable=False)
    Year = db.Column('Year', db.Integer, nullable=False)
    Merit_Rank = db.Column('Merit_Rank', db.Integer, nullable=False)
    Scholarship = db.Column('Scholarship', db.String(255), nullable=False)
    College_Type = db.Column('College_Type', db.String(255), nullable=False)
    Entrance_Exam_Accepted = db.Column('Entrance_Exam_Accepted',
                                       db.String(255), nullable=False)
    City = db.Column('City', db.Integer, nullable=False)
    Placement_Percentage = db.Column('Placement_Percentage', db.Integer,
                                     nullable=False)
    Library = db.Column('Library', db.String(255), nullable=False)
    Sports_Complex = db.Column('Sports_Complex', db.String(255),
                               nullable=False)

    def as_dict(self):
        return {
            'registration_id':self.registration_id,
            'College_Name':self.College_Name,
            'Degree_Name':self.Degree_Name,
            'Course_Name':self.Course_Name,
            'Branch_Seat': self.Branch_Seat,
            'Fees': self.Fees,
            'Year': self.Year,
            'Merit_Rank': self.Merit_Rank,
            'Scholarship': self.Scholarship,
            'College_Type': self.College_Type,
            'Entrance_Exam_Accepted': self.Entrance_Exam_Accepted,
            'City': self.City,
            'Placement_Percentage': self.Placement_Percentage,
            'Library': self.Library,
            'Sports_Complex': self.Sports_Complex,
        }
db.create_all()
