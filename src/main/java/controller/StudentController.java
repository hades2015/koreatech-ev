package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Student;
import security.SecurityStudentService;
import service.StudentService;
import utils.StatusCode;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SecurityStudentService secuService;
	
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
	public @ResponseBody JsonNode loginPost(@RequestParam String userId, @RequestParam String password) {

		ObjectNode resultMap = jacksonObjectMapper.createObjectNode();
		Student student = studentService.readStudentByUserId(userId);

		System.out.println("login()");

		if (password.equals(student.getPassword())) {
			resultMap.put("statusCode", StatusCode.OK);
		} else {
			resultMap.put("statusCode", StatusCode.ERROR);
		}
		return resultMap;
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUpView() {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public @ResponseBody JsonNode signUpPost(@ModelAttribute Student student) {
		System.out.println(student.getUserId());
		JsonNode signupResult = studentService.createStudent(student);
		secuService.craeteUserRole(student.getUserId());
		return signupResult;
	}
}
