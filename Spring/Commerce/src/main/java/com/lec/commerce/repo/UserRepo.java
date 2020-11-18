package com.lec.commerce.repo;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lec.commerce.domain.User;
@Repository
public class UserRepo {
	
	@PersistenceContext
	private EntityManager em;
	//saves user to database
	public void save(User user) {
		em.persist(user);
	}
	//returns a list of users matching username
	public List<User> findById(String userName) {
		return em.createQuery("select n from User n where n.userName = :userName").setParameter("userName", userName).getResultList();
		
	}
	
	public void updateStatus(String userName, String date) {
		String q = "update user set test_result = 1 where id = " + findById(userName).get(0).getId() + ";" ;
		String q2 = "update user set test_Date = '"+ date  +  "' where id = " + findById(userName).get(0).getId() + ";" ;
		em.createNativeQuery(q).executeUpdate();
		em.createNativeQuery(q2).executeUpdate();
	}
	
	
	public void resetStatus() {
		String q = "update user set test_date = null, test_result = 0 where test_date < DATE_SUB(NOW(),INTERVAL 15 DAY);" ;
		em.createNativeQuery(q).executeUpdate();
	}
}
