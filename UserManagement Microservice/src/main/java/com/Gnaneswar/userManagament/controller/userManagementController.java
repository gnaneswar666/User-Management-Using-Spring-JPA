package com.Gnaneswar.userManagament.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Gnaneswar.userManagament.model.User;
import com.Gnaneswar.userManagament.service.UserManagementService;

@RestController
@RequestMapping("api/User")
@CrossOrigin("*")
public class userManagementController {

	@Autowired
	private UserManagementService userService;
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user) {
		return userService.addUser(user); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
		return userService.updateUser(id,user);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		return userService.deleteuser(id);
	}
	
	
	
}
