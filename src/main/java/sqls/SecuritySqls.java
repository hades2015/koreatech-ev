package sqls;

public interface SecuritySqls {
	String CREATE_USER_ROLE = "INSERT INTO student_role(user_id, role) "
			+ "VALUES(?,?)";
}
