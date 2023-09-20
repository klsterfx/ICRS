package com.project.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.LoginVO;

@Repository
public class LoginDAOImp implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveLoginVO(LoginVO loginVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(loginVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	/*
	 * @Override public List<DatasetVO> getAllDatasetFiles(){ List<DatasetVO>
	 * datasetList = new ArrayList<DatasetVO>(); try { Session session =
	 * sessionFactory.getCurrentSession(); Query query =
	 * session.createQuery("from DatasetVO where status = true"); datasetList =
	 * (List<DatasetVO>) query.list(); } catch (Exception e) { e.printStackTrace();
	 * } return datasetList; }
	 */
}
