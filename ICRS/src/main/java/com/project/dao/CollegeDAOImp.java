package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CollegeVO;

@Repository
public class CollegeDAOImp implements CollegeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCollege(CollegeVO collageVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(collageVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public List<CollegeVO> searchCollege() {
		
		List<CollegeVO> colleges = new ArrayList<CollegeVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from CollegeVO where status=true");
			
			colleges = (List<CollegeVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return colleges;
	}
	
	@Override
	public List<CollegeVO> getCollegeById(int id) {
		
		List<CollegeVO> colleges = new ArrayList<CollegeVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from CollegeVO where status=true and collegeId = " + id);
			
			colleges = (List<CollegeVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return colleges;
	}
}
