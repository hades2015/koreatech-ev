package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import repository.SecurityRepository;

@Service
public class SecurityStudentService{
	
	@Autowired
	private SecurityRepository securityRepository; 
	
	public void craeteUserRole(String userId){
		securityRepository.createUserRole(userId);
	}
}
