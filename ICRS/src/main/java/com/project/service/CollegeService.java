package com.project.service;

import java.util.List;

import com.project.model.CollegeVO;

public interface CollegeService {
	
	void saveCollege(CollegeVO collegeVO);
	
	List<CollegeVO> searchCollege();
	
	List<CollegeVO> getCollegeById(int id); 
}
