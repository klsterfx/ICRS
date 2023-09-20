package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.PredictionVO;

@Repository
public class PredictionDAOImp implements PredictionDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void savePredictionVO(PredictionVO predictionVO) {

		try {

			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(predictionVO);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List searchPredictionCollegeDetails() {

		List<Object[]> ls = new ArrayList<>();

		Session session = sessionFactory.getCurrentSession();

		SQLQuery query = session.createSQLQuery(
				"SELECT pc.predicted_college,pd.college_type,pd.course_name,pd.degree_name,pd.placement_percentage,pd.tution_fees_range FROM predicted_college AS pc INNER JOIN prediction_data_table AS pd ON pc.college_prediction_id = pd.prediction_id");
		ls = query.list();

		return ls;
	}

	/*
	 * @Override public List<CollegeVO> searchCollege() {
	 * 
	 * List<CollegeVO> colleges = new ArrayList<CollegeVO>(); try {
	 * 
	 * Session session = sessionFactory.getCurrentSession();
	 * 
	 * Query query = session.createQuery("from CollegeVO where status=true");
	 * 
	 * colleges = (List<CollegeVO>)query.list(); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return colleges; }
	 * 
	 * @Override public List<CollegeVO> getCollegeById(int id) {
	 * 
	 * List<CollegeVO> colleges = new ArrayList<CollegeVO>(); try {
	 * 
	 * Session session = sessionFactory.getCurrentSession();
	 * 
	 * Query query =
	 * session.createQuery("from CollegeVO where status=true and collegeId = " +
	 * id);
	 * 
	 * colleges = (List<CollegeVO>)query.list(); } catch (Exception e) {
	 * e.printStackTrace(); }
	 * 
	 * return colleges; }
	 */
}
