package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dataset_table")
public class DatasetVO extends AuditAware {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "file_name")
	private String datasetFileName;
	
	@Column(name = "path")
	private String datasetPathName;
	
	@Column(name = "status")
	private boolean status = true;
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDatasetFileName() {
		return datasetFileName;
	}

	public void setDatasetFileName(String datasetFileName) {
		this.datasetFileName = datasetFileName;
	}

	public String getDatasetPathName() {
		return datasetPathName;
	}

	public void setDatasetPathName(String datasetPathName) {
		this.datasetPathName = datasetPathName;
	}

}
