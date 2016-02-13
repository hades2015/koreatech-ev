package repository;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import model.Student;
import sqls.StudentSqls;

@Repository
public class StudentRepository extends JdbcDaoSupport {
	@Resource
	private DataSource defaultDataSource;
	
	@PostConstruct
	private void init() {
		setDataSource(defaultDataSource);
	}
	
	public void createStudent(Student student) {
		getJdbcTemplate().update(StudentSqls.CREATE_STUDENT, 
					student.getUserId(), student.getPassword(), student.getName(),
					student.getNickName(), student.getDepartment(), student.getGrade(), 
					student.getStudentNumber(), student.getEmail());
	}

	public Student readStudentByUserId(String userId) {
		return getJdbcTemplate().queryForObject(StudentSqls.READ_STUDENT_BY_USER_ID,
					(rs, rowNum) -> new Student(
					rs.getString("user_id"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getString("nickname"),
					rs.getString("department"),
					rs.getInt("grade"),
					rs.getString("student_number"),
					rs.getString("email")),
					userId);
	}
	
	public void updateStudentByUserId(Student student) {
		getJdbcTemplate().update(StudentSqls.UPDATE_STUDENT_BY_USER_ID, 
					student.getPassword(), student.getName(), student.getNickName(),
					student.getDepartment(), student.getGrade(), student.getStudentNumber(),
					student.getEmail(), student.getUserId());
	}
	
	public void deleteStudentByUserId(String userId) {
		getJdbcTemplate().update(StudentSqls.DELETE_STUDENT_BY_USER_ID, userId);
	}
}
