package com.lec.commerce.service;

import java.sql.Timestamp;
import java.util.List;

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
	
	public List<Object[]> userVisit(String userName){
		
		return visitrepo.findUserVisits("user");
	}
	
	public List<Object[]> postiveVisits(){
		List<Object[]> posVisits = visitrepo.findPositiveVisits();
		return posVisits;
	}
	
	public boolean check(int a, int b, Timestamp uEnter, Timestamp uLeave, Timestamp pEnter, Timestamp pLeave) {
		if(a == b && uEnter.compareTo(pLeave) <= 0 && uLeave.compareTo(pEnter) >= 0)
			return true;
		else
			return false;
		
	}
}
