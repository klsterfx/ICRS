package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.RegisterDAO;
import com.project.model.RegisterVO;

@Service
@Transactional
public class RegisterServiceImp implements RegisterService{
	
	@Autowired
	private RegisterDAO registerDAO;
	
	@Override
	public void saveUser(RegisterVO registerVO) {
		this.registerDAO.saveUser(registerVO);		
	}
	
	/*
	 * public List<DatasetVO> getAllDatasetFiles(){ return
	 * this.dataSetDAO.getAllDatasetFiles(); }
	 */
}
