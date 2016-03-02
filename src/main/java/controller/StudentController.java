package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Student;
import service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
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
		Student student = studentService.readStudentByUserId(userId);
		if(password.equals(student.getPassword())) {
			return "redirect:evaluation";
		} else {
			return "redirect:login_fail";
		}
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.GET)
	public String signUpView() {
		return "signup";
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signUpPost(@ModelAttribute Student student) { 
		studentService.createStudent(student);
		return "redirect:login";
	}
}
