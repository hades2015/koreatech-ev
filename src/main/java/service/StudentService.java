package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Student;
import repository.StudentRepository;
import utils.StatusCode;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ObjectMapper jacksonObjectMapper;
	
	public JsonNode createStudent(Student student) {
		ObjectNode resultMap = jacksonObjectMapper.createObjectNode();

		// 빠진 데이터 검사
		if (student.getUserId() == null) {
			resultMap.put("errorMsg", "please fill ID input");
			return resultMap;
		}
		if (student.getPassword() == null) {
			resultMap.put("errorMsg", "please fill password input");
			return resultMap;
		}
		if (student.getUserName() == null) {
			resultMap.put("errorMsg", "please fill name input");
			return resultMap;
		}
		if (student.getNickname() == null) {
			resultMap.put("errorMsg", "please fill nickname input");
			return resultMap;
		}
		if (student.getStudentNumber() == null) {
			resultMap.put("errorMsg", "please fill student number input");
			return resultMap;
		}
		if (student.getUserEmail() == null) {
			resultMap.put("errorMsg", "please fill email input");
			return resultMap;
		}
		
		// 중복 계정 검사
		/* TODO with error check
		if (studentRepository.readStudentByUserId(student.getUserId()) != null) {
			resultMap.put("errorMsg", "Already Exists Id");
			return resultMap;
		}
		*/

		studentRepository.createStudent(student);
		resultMap.put("statusCode", StatusCode.OK);
		resultMap.put("redirectUrl", "/login");
		return resultMap;
	}
	
	public Student readStudentByUserId(String userId) {
		return studentRepository.readStudentByUserId(userId);
	}
	
	public void updateStudentByUserId(Student student) {
		studentRepository.updateStudentByUserId(student);
	}
	
	public void deleteStudentByUserId(String userId) {
		studentRepository.deleteStudentByUserId(userId);
	}
}
