package com.project.service;

import java.util.List;

import com.project.model.DatasetVO;

public interface DatasetService {
	
	void saveDataSetVO(DatasetVO dataSetVO);
	
	List<DatasetVO> getAllDatasetFiles();
}
