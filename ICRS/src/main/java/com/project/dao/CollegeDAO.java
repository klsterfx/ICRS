package com.project.dao;

import java.util.List;

import com.project.model.CollegeVO;

public interface CollegeDAO {
	
	void saveCollege(CollegeVO collageVO);
	
	List<CollegeVO> searchCollege();
	
	List<CollegeVO> getCollegeById(int id);
}
