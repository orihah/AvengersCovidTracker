package com.lec.commerce.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lec.commerce.domain.Location;
import com.lec.commerce.domain.User;
@Repository
public class LocationRepo{

	@PersistenceContext
	private EntityManager em;
	
	public void save(Location location) {
		em.persist(location);
	}
	
	public List<Location> findByName(String name) {
		return em.createQuery("select n from Location n where n.name = :name").setParameter("name", name).getResultList();
		
	}
}