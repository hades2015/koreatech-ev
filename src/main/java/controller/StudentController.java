package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Student;

@Controller
public class StudentController {
	@RequestMapping("/")
	public String root() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginPost(@RequestParam String userId, @RequestParam String password) {
		System.out.println(userId);
		System.out.println(password);
		return "evaluation";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUpView() {
		return "signup";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUpPost(@ModelAttribute Student student) { 
		System.out.println("Controller Catch");
		
		return "redirect:login";
	}
}
