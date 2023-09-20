package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.StateCityDAO;
import com.project.model.CityVO;
import com.project.model.StateVO;

@Service
@Transactional
public class StateCityServiceImp implements StateCityService{
	
	@Autowired
	private StateCityDAO stateCityDAO;
	
	@Override
	public void saveState(StateVO stateVO) {
		this.stateCityDAO.saveState(stateVO);
	}
	
	@Override
	public List<StateVO> searchState(){
		return this.stateCityDAO.searchState();
	}
	
	@Override
	public List<StateVO> getStateById(int id){
		return this.stateCityDAO.getStateById(id);
	}
	
	@Override
	public void saveCity(CityVO cityVO) {
		this.stateCityDAO.saveCity(cityVO);
	}
	
	@Override
	public List<CityVO> searchCity(){
		return this.stateCityDAO.searchCity();
	}
	
	@Override
	public List<CityVO> getCityById(int id){
		return this.stateCityDAO.getCityById(id);
	}

	@Override
	public List<CityVO> getCityByStateId(int stateId) {
		return this.stateCityDAO.getCityByStateId(stateId);
	}
}
