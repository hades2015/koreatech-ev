package repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.stereotype.Repository;

import model.SecurityStudent;
import sqls.SecuritySqls;
import sqls.StudentSqls;

@Repository
public class SecurityRepository extends JdbcDaoImpl {

	@Resource
	private DataSource defaultDataSource;

	@PostConstruct
	private void init() {
		setDataSource(defaultDataSource);
	}
	
	public void createUserRole(String userId){
		getJdbcTemplate().update(SecuritySqls.CREATE_USER_ROLE, 
				userId, "ROLE_USER");
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		SecurityStudent user = getJdbcTemplate().queryForObject(getUsersByUsernameQuery(), new RowMapper<SecurityStudent>() {
			public SecurityStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
				
				Collection<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
				
				SecurityStudent temp = new SecurityStudent();
				
				temp.setUserId(rs.getString("user_id"));
				temp.setPassword(rs.getString("password"));
				temp.setUserName(rs.getString("userName"));
				temp.setNickname(rs.getString("nickname"));
				temp.setDepartment(rs.getString("department"));
				temp.setGrade(rs.getInt("grade"));
				temp.setStudentNumber(rs.getString("student_number"));
				temp.setUserEmail(rs.getString("email"));
				
				do{
					auth.add(new SimpleGrantedAuthority(rs.getString("role")));
				}while((rs.next()));
				
				temp.setAuth(auth);
				
				return temp;
			}
		}, username);

		return user;
	}

}
