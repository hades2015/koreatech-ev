package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Student;
import repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public void createStudent(Student student) {
		studentRepository.createStudent(student);
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
