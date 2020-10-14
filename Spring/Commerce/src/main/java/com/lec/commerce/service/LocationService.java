package com.lec.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.repo.LocationRepo;
import com.lec.commerce.repo.UserRepo;
@Service
@Transactional
public class LocationService {
	@Autowired 
	private LocationRepo locationrepo;
}
