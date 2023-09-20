package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.CityVO;
import com.project.model.CollegeVO;
import com.project.model.StateVO;

@Repository
public class StateCityDAOImp implements StateCityDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveState(StateVO stateVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(stateVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void saveCity(CityVO cityVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(cityVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public List<StateVO> searchState() {
		
		List<StateVO> states = new ArrayList<StateVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from StateVO where status=true");
			
			states = (List<StateVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return states;
	}
	@Override
	public List<CityVO> searchCity() {
		
		List<CityVO> cities = new ArrayList<CityVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from CityVO where status=true");
			
			cities = (List<CityVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cities;
	}
	
	@Override
	public List<StateVO> getStateById(int id) {
		
		List<StateVO> states = new ArrayList<StateVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from StateVO where status=true and stateId = " + id);
			
			states = (List<StateVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return states;
	}
	
	@Override
	public List<CityVO> getCityById(int id) {
		
		List<CityVO> cities = new ArrayList<CityVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from CityVO where status=true and cityId = " + id);
			
			cities = (List<CityVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cities;
	}
	
	@Override
	public List<CityVO> getCityByStateId(int stateId) {
		
		List<CityVO> cities = new ArrayList<CityVO>();
		try {

			Session session = sessionFactory.getCurrentSession();

			Query query = session.createQuery("from CityVO where status=true and stateVO = " + stateId);
			
			cities = (List<CityVO>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cities;
	}
}
