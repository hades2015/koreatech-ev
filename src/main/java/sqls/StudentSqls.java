package sqls;

public interface StudentSqls {
	String CREATE_STUDENT = "INSERT INTO student(user_id, password, name, nickname, department, grade, " +
			"student_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	
	String READ_STUDENT_BY_USER_ID = "SELECT user_id, password, name, nickname, department, grade, " +
			"student_number, email FROM student WHERE user_id = ?";
	
	String UPDATE_STUDENT_BY_USER_ID = "UPDATE student SET password = ?, name = ?, nickname = ?, " +
			"department = ?, grade = ?, student_number = ?, email = ? WHERE user_id = ?";
	
	String DELETE_STUDENT_BY_USER_ID = "DELETE FROM student WHERE userId = ?";
}
