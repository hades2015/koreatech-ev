package model;

public class Student {
	private String userId;
	private String password;
	private String name;
	private String nickName;
	private String department;
	private int grade;
	private String studentNumber;
	private String email;
	
	public Student() {	/* ModelAttribute를 위해 작성 */ }
	
	public Student(String userId, String password, String name, String nickName, String department, int grade,
			String studentNumber, String email) {
		super();
		this.userId = userId;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.department = department;
		this.grade = grade;
		this.studentNumber = studentNumber;
		this.email = email;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
