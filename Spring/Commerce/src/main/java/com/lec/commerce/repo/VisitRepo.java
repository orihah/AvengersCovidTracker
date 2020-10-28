package com.lec.commerce.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
