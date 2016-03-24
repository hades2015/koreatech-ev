package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityStudentService{
	
	@Autowired
	private SecurityRepository securityRepository; 
	
	public void craeteUserRole(String userId){
		securityRepository.createUserRole(userId);
	}
}