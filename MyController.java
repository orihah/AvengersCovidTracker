package com.lec.commerce.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lec.commerce.domain.Location;
import com.lec.commerce.domain.User;
import com.lec.commerce.domain.Visit;
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
	
	
	@GetMapping("/verification.html")
	public ModelAndView verification() {	
		ModelAndView veri = new ModelAndView();	
		veri.setViewName("verification");
		return veri;
	}
	
	@GetMapping("/case_form.html")
	public ModelAndView case_form() {	
		ModelAndView case_form = new ModelAndView();	
		case_form.setViewName("case_form");
		return case_form;
	}
	
	@GetMapping("/personal_history_log.html")
	public ModelAndView personal() {	
		ModelAndView personal = new ModelAndView();	
		personal.setViewName("personal_history_log");
		return personal;
	}
	

		
	@GetMapping("/covid19_warning_page.html")
	public ModelAndView warning() {	
		ModelAndView warn = new ModelAndView();	
		warn.setViewName("covid19_warning_page");
		return warn;
		
	}
	
	@GetMapping("/visit_form.html")
	public ModelAndView time() {	
		ModelAndView time = new ModelAndView();	
		time.setViewName("visit_form");
		return time;
		
	}
	
	@GetMapping("/sign-up.html")
	public ModelAndView sign() {	
		ModelAndView time = new ModelAndView();	
		time.setViewName("sign-up");
		return time;
		
	}
	
	@GetMapping("/profile_log.html")
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
	
	@SuppressWarnings("deprecation")
	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)
	public String enter(String userName, String locName, Integer eHour, Integer eMin, String date, 
			Integer lHour, Integer lMin, String eampm, String lampm) {
		if(eampm.compareTo("P.M.") == 0)
			eHour = eHour + 12;
		if(lampm.compareTo("P.M.") == 0)
			lHour = lHour + 12;
			
		Integer month = Integer.parseInt(date.substring(0, 2));
		Integer day = Integer.parseInt(date.substring(3, 5));
		Integer year = Integer.parseInt(date.substring(6, 10));
		List<User> users = userRepo.findById(userName);
		List<Location> locs = locRepo.findByName(locName);
		System.out.println(userName);
		System.out.println(users.get(0).getEmail());
		System.out.println(locName);
		System.out.println(locs.get(0).getId());
		System.out.println(eHour);
		System.out.println(eMin);
		System.out.println(lHour);
		System.out.println(lMin);
		System.out.println(month);
		System.out.println(day);
		System.out.println(year);
		
		
		
		Visit dvisit = new Visit();
		dvisit.setUser(userRepo.findById(userName).get(0));
		dvisit.setLocation(locRepo.findByName(locName).get(0));
		dvisit.setEnterTime(new java.sql.Timestamp(year, month, day, eHour, eMin, 0, 0));
		dvisit.setLeaveTime(new java.sql.Timestamp(year, month, day, lHour, lMin, 0, 0));
		int savedId = visitService.join(dvisit);
		
		return "personal_history_log";
	}
	
	@RequestMapping(value = "/verified", method = RequestMethod.GET)
	public String verified(String name, String password) {
		System.out.println("userid " + name);
		System.out.println("password " + password);
		
		if(userService.verify(name, password)) 
			return "visit_form";
		else
			return
					"verification";
		
		
	}

	
	
	
}


