package com.project.dao;

import java.util.List;

import com.project.model.DatasetVO;

public interface DatasetDAO {
	
	void saveDataSet(DatasetVO datasetVO);
	
	List<DatasetVO> getAllDatasetFiles();
	
}
