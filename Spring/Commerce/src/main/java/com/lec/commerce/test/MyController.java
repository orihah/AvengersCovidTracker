package com.lec.commerce.test;	
import java.sql.Timestamp;	
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;	
import org.springframework.stereotype.Controller;	
import org.springframework.ui.Model;	
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
		
	boolean loginStatus = false;	
	String currUser;	
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
	//called for creating several test users	
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
	//used to add new user, called from sign-up page redirects to sign-in	
	@RequestMapping(value = "/create", method = RequestMethod.GET)	
	public String create(String userID, String password, String name, String email) {	
//		System.out.println("userid " + userID);	
//		System.out.println("password " + password);	
//		System.out.println("name " + name);	
//		System.out.println("email " + email);	
//			
		User duser = new User();	
		duser.setUserName(userID);	
		duser.setPassword(password);	
		duser.setName(name);	
		duser.setEmail(email);	
		int savedId = userService.join(duser);	
			
		return "verification";	
	}	
	//logs a visit to the database, currently only uses 'user' as username.  Redirects to personal history log	
	@RequestMapping(value = "/enter", method = RequestMethod.GET)	
	public String enter(String userName, String locName, Integer eHour, Integer eMin, String date, 	
			Integer lHour, Integer lMin, String eampm, String lampm) {	
		if(eampm.compareTo("P.M.") == 0)	
			eHour = eHour + 12;	
		if(lampm.compareTo("P.M.") == 0)	
			lHour = lHour + 12;	
				
		Integer month = Integer.parseInt(date.split("/")[0]);	
		Integer day = Integer.parseInt(date.split("/")[1]);	
		Integer year = Integer.parseInt(date.split("/")[2]);	
		System.out.println(year);	
		List<User> users = userRepo.findById(currUser);	
		List<Location> locs = locRepo.findByName(locName);	
		System.out.println(currUser);	
		Visit dvisit = new Visit();	
		dvisit.setUser(userRepo.findById(currUser).get(0));	
		dvisit.setLocation(locRepo.findByName(locName).get(0));	
		dvisit.setEnterTime(new java.sql.Timestamp(year-1900, month-1, day, eHour, eMin, 0, 0));	
		dvisit.setLeaveTime(new java.sql.Timestamp(year-1900, month-1, day, lHour, lMin, 0, 0));	
		int savedId = visitService.join(dvisit);	
			
		return "personal_history_log";	
	}	
		
	@RequestMapping(value= "/statusUpdate", method = RequestMethod.GET)	
		public String statusUpdate(String date) {	
		userService.statusUpdate(currUser, date);	
		return "personal_history_log";	
	}	
		
		
	//first checks for valid log-in, then user visits against positive visits.  If valid log-in and no contact redirects to visit log, if contact redirect to warning page, if non-valid login back to sign-in	
	@RequestMapping(value = "/verified", method = RequestMethod.GET)	
	public String verified(String name, String password, Model model) {	
			
		model.addAttribute("userid", name);	
//		System.out.println("userid " + name);	
//		System.out.println("password " + password);	
		List<Object[]> pos = visitService.postiveVisits();	
		List<Object[]> vis = visitService.userVisit(name);	
//		for(int i = 0; i < pos.size(); i++)	
//		{	
//			System.out.println();	
//			for(int j = 0; j < pos.get(i).length; j++) {	
//				System.out.print(pos.get(i)[j] + " ");	
//			}	
//		}	
		User user = userService.getUser(name);
		if(userService.verify(user)) { 	
			userService.statusReset();	
			visitService.resetVisits();	
			for(int i = 0; i < vis.size(); i++)	
				for(int j = 0; j < pos.size(); j++) {	
					if(visitService.check((int)vis.get(i)[3],(int)pos.get(j)[3],(Timestamp)vis.get(i)[1], (Timestamp)vis.get(i)[2], (Timestamp)pos.get(j)[1],(Timestamp) pos.get(j)[2])) {	
					loginStatus = true;	
					currUser = name;	
					return "covid19_warning_page";	
					}	
				}	
			currUser = name;	
			loginStatus = true;	
			return "visit_form";	
		}	
		else	
			return	
					"verification";	
			
			
	}	
	@Controller
	public class ErrorController {

	    @RequestMapping(value = "/errors", method = RequestMethod.GET)
	    public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {
	        
	        ModelAndView errorPage = new ModelAndView("errorPage");
	        String errorMsg = "";
	        int httpErrorCode = getErrorCode(httpRequest);

	        switch (httpErrorCode) {
	            case 400: {
	                errorMsg = "Http Error Code: 400. Bad Request";
	                break;
	            }
	            case 401: {
	                errorMsg = "Http Error Code: 401. Unauthorized";
	                break;
	            }
	            case 404: {
	                errorMsg = "Http Error Code: 404. Resource not found";
	                break;
	            }
	            case 500: {
	                errorMsg = "Http Error Code: 500. Internal Server Error";
	                break;
	            }
	        }
	        errorPage.addObject("errorMsg", errorMsg);
	        return errorPage;
	    }
	    
	    private int getErrorCode(HttpServletRequest httpRequest) {
	        return (Integer) httpRequest
	          .getAttribute("javax.servlet.error.status_code");
	    }
	}
		
		
		
}