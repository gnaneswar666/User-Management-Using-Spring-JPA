package com.Gnaneswar.userManagament.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Gnaneswar.userManagament.model.User;
import com.Gnaneswar.userManagament.repository.UserManagementRepository;

@Service
public class UserManagementService {

	
	@Autowired
	private UserManagementRepository  userRepo;

	public ResponseEntity<User> addUser(User user) {
		User addedUser=userRepo.save(user);
		return new ResponseEntity<User>(addedUser,HttpStatus.CREATED);
		
		
	}

	public ResponseEntity<User> getUserById(int id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepo.findById(id);
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return  new ResponseEntity<>(user.get(),HttpStatus.OK);
		}
	}

	public ResponseEntity<List<User>> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users=userRepo.findAll();
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}

	public ResponseEntity<User> updateUser(int id,User user) {
		// TODO Auto-generated method stub
		Optional<User> retreivedUser=userRepo.findById(id);
		if(retreivedUser.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		else {
			User use=retreivedUser.get();
			use.setName(user.getName());
			use.setEmail(user.getEmail());
			use.setAge(user.getAge());
			use.setPassword(user.getPassword());
			userRepo.save(use);
			return new ResponseEntity<>(use,HttpStatus.CREATED);

		}
	
	}

	public ResponseEntity<User> deleteuser(int id) {
		// TODO Auto-generated method stub
		Optional<User> user=userRepo.findById(id);
	
		if(user.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
		else {
			userRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);

		}
	}
	
	
	

	


}
