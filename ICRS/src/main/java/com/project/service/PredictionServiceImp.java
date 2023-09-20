package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.PredictionDAO;
import com.project.model.PredictionVO;

@Service
@Transactional
public class PredictionServiceImp implements PredictionService {

	@Autowired
	private PredictionDAO predictionDAO;

	public void savePredictionVO(PredictionVO predictionVO) {
		this.predictionDAO.savePredictionVO(predictionVO);

	}

	 @Override
	 public List searchPredictionCollegeDetails() {
	 return this.predictionDAO.searchPredictionCollegeDetails();
	 }

	/*
	 * public List<CollegeVO> searchCollege(){ return
	 * this.collageDAO.searchCollege(); }
	 * 
	 * @Override public List<CollegeVO> getCollegeById(int id) { return
	 * this.collageDAO.getCollegeById(id); }
	 */
}
