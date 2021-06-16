package com.prototype.auditauthentication.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import com.prototype.auditauthentication.model.ProjectManager;
import com.prototype.auditauthentication.repository.ManagerRepo;

/**
This class is used to load the user details from database and
*          checking whether the user resides in database or not based on the
*          given id. This class will implement the {@link UserDetailsService}
*          interface. The interface requires only one read-only method, which
*          simplifies support for newdata-access strategies.
*/

@Service
public class ManagerService implements UserDetailsService {

	/**
	 * This field is used to communicate with the database. It has the annotation
	 * autowired which will automatically inject the bean.
	 * 
	
	 */
	
	@Autowired
	ManagerRepo managerRepo;

	/**
	 * This method is used to load the user details from database and checking
	 * whether the user resides in database or not based on the given id. If the
	 * user not present in the database it will throw an exception
	 * UsernameNotFoundException. And if user is present in the database it will
	 * simply return the {@link User} object
	 * 
	
	 */
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		ProjectManager  manager = managerRepo.findById(username).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email: " + username));
		return new User(manager.getUserId(),manager.getPassword(),new ArrayList<>());
	}

	public void saveUser(ProjectManager projectManager) {

		managerRepo.save(projectManager);
	}

}
