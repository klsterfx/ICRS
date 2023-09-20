package com.project.service;

import java.util.List;

import com.project.model.PredictionVO;

public interface PredictionService {

	void savePredictionVO(PredictionVO collegeVO);

	List searchPredictionCollegeDetails();
	/*
	 * List<CollegeVO> searchCollege();
	 * 
	 * List<CollegeVO> getCollegeById(int id);
	 */

}
