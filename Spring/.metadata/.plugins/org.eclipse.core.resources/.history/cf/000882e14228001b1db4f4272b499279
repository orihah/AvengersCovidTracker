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
	
	public void save(Visit visit) {
		em.persist(visit);
	}
	
	public List<Object[]> findUserVisits(String userName) {
		
		//return em.createQuery("select v from Visit v where v.userName = :userName").setParameter("userName", userName).getResultList();
		Query q = em.createNativeQuery("SELECT Visit.* FROM commerce.visit INNER JOIN commerce.user ON visit.user_id=user.id where user_name = \"user\";");
		return q.getResultList();
	}
	
	public List<Object[]> findPositiveVisits() {
		Query q = em.createNativeQuery("SELECT Visit.* FROM Visit INNER JOIN User ON Visit.user_id=User.id where test_result = 1;");
		return q.getResultList();
	}
	
	
}
