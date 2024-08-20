package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.entity.User;
import com.repository.RepoClass;

@Service
public class ServiceClass {
	@Autowired
	private RepoClass repo;

	public User userDetails(String username) {
		User gettinguser = repo.gettinguser(username);
		return gettinguser;
	}

	public void saveUser(User user) {
		System.out.println("in service");
		repo.saving(user);
	}

	public void userUpdate(User user) throws Exception {
		System.out.println("in service");
		repo.updating(user);
		
	}

	public void updatingPatchUser(User user) throws Exception {
		User existingUser = repo.gettinguser(user.getUsername());
		if(existingUser!=null) {
			if(user.getName()!=null) {
				existingUser.setName(user.getName());
			}
			if(user.getPassword()!=null) {
				existingUser.setPassword(user.getPassword());
			}
			repo.updating(existingUser);
		}else {
			throw new Exception("user not found");
		}
		
	}

	public void delete(String username) {
		repo.deleting(username);
	}




}
