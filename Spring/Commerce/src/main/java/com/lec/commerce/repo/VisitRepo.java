package com.lec.commerce.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository
public class VisitRepo {
	@PersistenceContext
	private EntityManager em;
}
