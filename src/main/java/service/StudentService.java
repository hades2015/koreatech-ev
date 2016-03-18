package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.Student;
import repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	ObjectMapper jacksonObjectMapper;
	
	public JsonNode createStudent(Student student) {
		ObjectNode resultMap = jacksonObjectMapper.createObjectNode();
		boolean isOk = true;
		studentRepository.createStudent(student);
		
		resultMap.put("status", isOk);
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
