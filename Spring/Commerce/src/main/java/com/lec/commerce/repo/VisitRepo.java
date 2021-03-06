package com.lec.commerce.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lec.commerce.domain.User;
import com.lec.commerce.domain.Visit;
@Repository
public class VisitRepo {
	@PersistenceContext
	private EntityManager em;
	//add visit to database
	public void save(Visit visit) {
		em.persist(visit);
	}
	//returns a list of object arrays with visits of a named user, [0] = id [1] = enter_time [2] = leave_time [3] = location_id [4] = user_id
	public List<Object[]> findUserVisits(String userName) {
		
		//return em.createQuery("select v from Visit v where v.userName = :userName").setParameter("userName", userName).getResultList();
		String query = "SELECT Visit.* FROM commerce.visit INNER JOIN commerce.user ON visit.user_id=user.id where user_name = \""+userName+"\";";
		//System.out.println(query);
		Query q = em.createNativeQuery(query);
		return q.getResultList();
	}
	//returns a list of object arrays with visits of positive case users, [0] = id [1] = enter_time [2] = leave_time [3] = location_id [4] = user_id
	public List<Object[]> findPositiveVisits() {
		Query q = em.createNativeQuery("SELECT Visit.* FROM Visit INNER JOIN User ON Visit.user_id=User.id where test_result = 1;");
		return q.getResultList();
	}
	
	public void resetVisits() {
		String q = "delete from visit where leave_time < DATE_SUB(NOW(),INTERVAL 15 DAY);" ;
		em.createNativeQuery(q).executeUpdate();
	}
	
}
