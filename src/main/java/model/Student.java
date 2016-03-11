package model;

public class Student {
	private String userId;
	private String password;
	private String userName;
	private String nickname;
	private String department;
	private int grade;
	private String studentNumber;
	private String userEmail;
	
	public Student() {	/* ModelAttribute를 위해 작성 */ }
	
	public Student(String userId, String password, String userName, String nickname, String department, int grade,
			String studentNumber, String userEmail) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickname = nickname;
		this.department = department;
		this.grade = grade;
		this.studentNumber = studentNumber;
		this.userEmail = userEmail;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
}
