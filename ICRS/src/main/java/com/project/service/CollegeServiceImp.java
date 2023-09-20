package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.CollegeDAO;
import com.project.model.CollegeVO;

@Service
@Transactional
public class CollegeServiceImp implements CollegeService{
	
	@Autowired
	private CollegeDAO collageDAO;
	
	public void saveCollege(CollegeVO collegeVO){
		this.collageDAO.saveCollege(collegeVO);
	}
	
	public List<CollegeVO> searchCollege(){
		return this.collageDAO.searchCollege();
	}

	@Override
	public List<CollegeVO> getCollegeById(int id) {
		return this.collageDAO.getCollegeById(id);
	}
	
}
