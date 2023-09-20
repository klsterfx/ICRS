package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "college_table")
public class CollegeVO extends AuditAware {

	@Id
	@Column(name = "college_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int collegeId;

	@Column(name = "college_name")
	private String collegeName;

	@Column(name = "college_description")
	private String description;

	@Column(name = "college_address")
	private String address;

	@Column(name = "status")
	private boolean status = true;

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
