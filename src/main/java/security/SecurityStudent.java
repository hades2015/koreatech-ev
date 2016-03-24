package security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityStudent implements UserDetails {

	private static final long serialVersionUID = -7722824403922244763L;
	private String userId;
	private String password;
	private String userName;
	private String nickname;
	private String department;
	private int grade;
	private String studentNumber;
	private String userEmail;

	private Collection<GrantedAuthority> auth;

	public SecurityStudent(String userId, String password, String userName, String nickname, String department, int grade, 
			String studentNumber, String userEmail, Collection<GrantedAuthority> auth) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
		this.nickname = nickname;
		this.department = department;
		this.grade = grade;
		this.studentNumber = studentNumber;
		this.userEmail = userEmail;
		this.auth = auth;
	}

	public SecurityStudent() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public Collection<GrantedAuthority> getAuth() {
		return auth;
	}

	public void setAuth(Collection<GrantedAuthority> auth) {
		this.auth = auth;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auth;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
