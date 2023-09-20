package com.project.service;

import java.util.List;

import com.project.model.CityVO;
import com.project.model.CollegeVO;
import com.project.model.StateVO;

public interface StateCityService {
	

	void saveState(StateVO stateVO);
	
	List<StateVO> searchState();
	
	List<StateVO> getStateById(int id);
	
	void saveCity(CityVO cityVO);
	
	List<CityVO> searchCity();
	
	List<CityVO> getCityById(int id);
	
	List<CityVO> getCityByStateId(int stateId);
}
