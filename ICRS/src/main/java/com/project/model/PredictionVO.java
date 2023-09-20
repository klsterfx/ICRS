package com.project.model;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Prediction_data_table")
public class PredictionVO extends AuditAware{

	@Id
	@Column(name = "prediction_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int predictionId;

	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "degree_name")
	private String degreeName;

	@Column(name = "college_type")
	private String collegeType; 

	@Column(name = "scholarships")
	private String scholarships;

	@Column(name = "entrance_exam")
	private String entranceExam;

	@Column(name = "library")
	private String library;
	
	@Column(name = "merit_rank")
	private String meritRank;
	
	@Column(name = "sport_complex")
	private String sportComplex;
	
	@Column(name = "tution_fees_range")
	private String tutionFeesRange;
	
	@Column(name = "placement_percentage")
	private String placementPercentage;
	
	private int year = Calendar.getInstance().get(Calendar.YEAR);
	
	@ManyToOne
	@JoinColumn(name = "college_id")
	private CollegeVO collegeVO;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityVO cityVO;

	@ManyToOne
	@JoinColumn(name = "state_id")
	private StateVO stateVO;
	
	@Column(name = "status")
	private boolean status = true;

	
	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	public int getPredictionId() {
		return predictionId;
	}

	public void setPredictionId(int predictionId) {
		this.predictionId = predictionId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCollegeType() {
		return collegeType;
	}

	public void setCollegeType(String collegeType) {
		this.collegeType = collegeType;
	}

	public String getScholarships() {
		return scholarships;
	}

	public void setScholarships(String scholarships) {
		this.scholarships = scholarships;
	}

	public String getEntranceExam() {
		return entranceExam;
	}

	public void setEntranceExam(String entranceExam) {
		this.entranceExam = entranceExam;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}

	public String getMeritRank() {
		return meritRank;
	}

	public void setMeritRank(String meritRank) {
		this.meritRank = meritRank;
	}

	public String getSportComplex() {
		return sportComplex;
	}

	public void setSportComplex(String sportComplex) {
		this.sportComplex = sportComplex;
	}

	public String getTutionFeesRange() {
		return tutionFeesRange;
	}

	public void setTutionFeesRange(String tutionFeesRange) {
		this.tutionFeesRange = tutionFeesRange;
	}

	public CollegeVO getCollegeVO() {
		return collegeVO;
	}

	public void setCollegeVO(CollegeVO collegeVO) {
		this.collegeVO = collegeVO;
	}

	public CityVO getCityVO() {
		return cityVO;
	}

	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}

	public StateVO getStateVO() {
		return stateVO;
	}

	public void setStateVO(StateVO stateVO) {
		this.stateVO = stateVO;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getPlacementPercentage() {
		return placementPercentage;
	}

	public void setPlacementPercentage(String placementPercentage) {
		this.placementPercentage = placementPercentage;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
}
