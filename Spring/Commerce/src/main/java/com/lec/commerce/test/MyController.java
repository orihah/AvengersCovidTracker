package com.lec.commerce.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lec.commerce.domain.User;
import com.lec.commerce.repo.LocationRepo;
import com.lec.commerce.repo.UserRepo;
import com.lec.commerce.repo.VisitRepo;
import com.lec.commerce.service.LocationService;
import com.lec.commerce.service.UserService;
import com.lec.commerce.service.VisitService;

@Controller

public class MyController {
	@Autowired 
	private VisitRepo visitRepo;
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private LocationRepo locRepo;
	@Autowired
	private LocationService locService;
	@Autowired
	private UserService userService;
	@Autowired
	private VisitService visitService;
	
	@GetMapping("/dummy")
	public String dummyFill() {
		userService.dummyUsers();
		return "<h1>database seeded<h1>";
	}
	
	
	@GetMapping("/verification")
	public ModelAndView verification() {	
		ModelAndView veri = new ModelAndView();	
		veri.setViewName("verification");
		return veri;
	}
		
	@GetMapping("/covid19_warning_page")
	public ModelAndView warning() {	
		ModelAndView warn = new ModelAndView();	
		warn.setViewName("covid19_warning_page");
		return warn;
		
	}
	
	@GetMapping("/timefield")
	public ModelAndView time() {	
		ModelAndView time = new ModelAndView();	
		time.setViewName("timefield");
		return time;
		
	}
	
	@GetMapping("/sign-up")
	public ModelAndView sign() {	
		ModelAndView time = new ModelAndView();	
		time.setViewName("sign-up");
		return time;
		
	}
	
	@GetMapping("/profile_log")
	public ModelAndView profile() {	
		ModelAndView page = new ModelAndView();	
		page.setViewName("profile_log");
		return page;
		
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(String userID, String password, String name, String email) {
		System.out.println("userid " + userID);
		System.out.println("password " + password);
		System.out.println("name " + name);
		System.out.println("email " + email);
		
		User duser = new User();
		duser.setUserName(userID);
		duser.setPassword(password);
		duser.setName(name);
		duser.setEmail(email);
		int savedId = userService.join(duser);
		
		return "verification";
	}

	
	
	
}

