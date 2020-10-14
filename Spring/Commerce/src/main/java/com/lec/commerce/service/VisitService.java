package com.lec.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.repo.UserRepo;
import com.lec.commerce.repo.VisitRepo;

@Service
@Transactional
public class VisitService {
	@Autowired 
	private VisitRepo visitrepo;
}
