package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Student;
import service.SecurityStudentService;
import service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SecurityStudentService securityService;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUpView() {
		return "signup";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUpPost(@ModelAttribute Student student) {
		
		studentService.createStudent(student);
		securityService.craeteUserRole(student.getUserId());
		
		return "redirect:login";
	}

}
