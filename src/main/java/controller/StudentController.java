package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Student;
import service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@Autowired
	ObjectMapper jacksonObjectMapper;
	
	@RequestMapping("/")
	public String root() {
		return "redirect:login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@RequestParam String userId, @RequestParam String password, HttpSession sessions) {
		
		Student student = studentService.readStudentByUserId(userId);
		
		if(password.equals(student.getPassword())) {
			
			sessions.setAttribute("userId", student.getUserId());
			sessions.setAttribute("userName", student.getUserName());
			sessions.setAttribute("nickname", student.getNickname());
			sessions.setAttribute("department", student.getDepartment());
			sessions.setAttribute("grade", student.getGrade());
			sessions.setAttribute("studentNumber", student.getStudentNumber());
			sessions.setAttribute("userEmail", student.getUserEmail());
			
			return "redirect:evaluation";
		
		} else {
		
			return "redirect:login_fail";
		
		}	
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUpView() {
		return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody JsonNode signUpPost(@ModelAttribute Student student) {
		return studentService.createStudent(student);
	}
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redirect:login";
	}
}
