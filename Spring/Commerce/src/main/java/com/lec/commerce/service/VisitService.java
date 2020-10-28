package com.lec.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.User;
import com.lec.commerce.domain.Visit;
import com.lec.commerce.repo.UserRepo;
import com.lec.commerce.repo.VisitRepo;

@Service
@Transactional
public class VisitService {
	@Autowired 
	private VisitRepo visitrepo;
	
	public int join(Visit visit) {
		
		visitrepo.save(visit);
		return visit.getId();
	}
}
