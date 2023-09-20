package com.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.LoginDAO;
import com.project.model.LoginVO;

@Service
@Transactional
public class LoginServiceImp implements LoginService{
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public void savelLoginVO(LoginVO loginVO) {
		this.loginDAO.saveLoginVO(loginVO);
	}
	
	/*
	 * public List<DatasetVO> getAllDatasetFiles(){ return
	 * this.dataSetDAO.getAllDatasetFiles(); }
	 */
}
