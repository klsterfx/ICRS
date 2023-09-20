package com.project.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.DatasetDAO;
import com.project.model.DatasetVO;

@Service
@Transactional
public class DatasetServiceImp implements DatasetService{
	
	@Autowired
	private DatasetDAO dataSetDAO;
	
	@Override
	public void saveDataSetVO(DatasetVO dataSetVO) {
		this.dataSetDAO.saveDataSet(dataSetVO);		
	}
	
	public List<DatasetVO> getAllDatasetFiles(){
		return this.dataSetDAO.getAllDatasetFiles();
	}
}
