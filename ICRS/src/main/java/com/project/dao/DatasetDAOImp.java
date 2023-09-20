package com.project.dao;

import java.util.ArrayList;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DatasetVO;

@Repository
public class DatasetDAOImp implements DatasetDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveDataSet(DatasetVO dataSetVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(dataSetVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public List<DatasetVO> getAllDatasetFiles(){
		List<DatasetVO> datasetList = new ArrayList<DatasetVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from DatasetVO where status = true");
			datasetList = (List<DatasetVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return datasetList;
	}

}
