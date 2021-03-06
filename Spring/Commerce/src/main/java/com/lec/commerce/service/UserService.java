package com.lec.commerce.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lec.commerce.domain.User;
import com.lec.commerce.repo.UserRepo;

@Service
@Transactional
public class UserService {
	@Autowired 
	private UserRepo userRepo;
	//add user after validating that username is not already taken
	public int join(User user) {
		validateUser(user);
		userRepo.save(user);
		return user.getId();
	}
	
	public void statusUpdate(String userName, String date) {
		String reDate = date.split("/")[2] + "/" + date.split("/")[0] + "/" + date.split("/")[1];
		//System.out.println(reDate);
		userRepo.updateStatus(userName, reDate);
	}
	
	public void statusReset() {
		userRepo.resetStatus();
	}
	
	public boolean verify(String userName, String password) {
		List<User> users = userRepo.findById(userName);
		if(users.isEmpty()) {
			throw new IllegalStateException("no such id");
		}
		else if(users.get(0).getPassword().compareTo(password) == 0)
			return true;
		else
		{
			System.out.println(users.get(0).getPassword());
			return false;
		}
			
	}
	
	
	//verify username isnt taken
	public void validateUser(User user) {
		List<User> users = userRepo.findById(user.getUserName());
		if(!users.isEmpty()) {
			throw new IllegalStateException("id exists");
		}
	}
	
	//adds serveral users to the databse
	public void dummyUsers() {
		User u1 = new User();
		u1.setEmail("u1@lec.com");
		u1.setName("Jerry Smith");
		u1.setPassword("1234");
		u1.setTestResult(false);
		u1.setUserName("user1");
		join(u1);
		
		User u2 = new User();
		u2.setEmail("u2@lec.com");
		u2.setName("Bob Sacamano");
		u2.setPassword("4321");
		u2.setTestResult(true);
		u2.setUserName("user2");
		join(u2);
		
		User u3 = new User();
		u3.setEmail("u3@lec.com");
		u3.setName("Linda Belcher");
		u3.setPassword("1212");
		u3.setTestResult(false);
		u3.setUserName("user3");
		join(u3);
		
		User u4 = new User();
		u4.setEmail("u4@lec.com");
		u4.setName("Test Subject");
		u4.setPassword("2121");
		u4.setTestResult(false);
		u4.setUserName("user4");
		join(u4);
		
	}
	
}
