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
import com.Gnaneswar.userManagament.model.Users;
import com.Gnaneswar.userManagament.service.CustomUserDetailsService;
import com.Gnaneswar.userManagament.service.UserManagementService;

@RestController
@RequestMapping("/api")

@CrossOrigin(origins = "http://localhost:5173")
public class userManagementController {

	@Autowired
	private UserManagementService userService;
	@Autowired
	private CustomUserDetailsService usersService;
	
	@PostMapping("/register")
	public ResponseEntity<Users> addUser(@RequestBody Users user) {
		return usersService.addUser(user); 
	}
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user){
		return userService.addUser(user);
	 }
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		return userService.getUserById(id);
	 }
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return userService.getAllUsers();
	}
	
	
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user){
		return userService.updateUser(id,user);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable int id){
		System.out.println("hello");
		return userService.deleteuser(id);
	}
	
	
	
}
