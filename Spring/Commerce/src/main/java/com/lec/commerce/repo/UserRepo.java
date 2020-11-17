package com.lec.commerce.repo;

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
}
