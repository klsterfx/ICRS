package com.project.dao;

import java.util.List;

import com.project.model.PredictionVO;

public interface PredictionDAO {

	void savePredictionVO(PredictionVO predictionVO);

	List searchPredictionCollegeDetails();

	/*
	 * List<CollegeVO> searchCollege();
	 * 
	 * List<CollegeVO> getCollegeById(int id);
	 */

}
