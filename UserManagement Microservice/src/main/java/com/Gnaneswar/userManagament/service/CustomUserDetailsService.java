package com.Gnaneswar.userManagament.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Gnaneswar.userManagament.model.Users;
import com.Gnaneswar.userManagament.repository.UsersRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsersRepository usersRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usersRepo.findByUsername(username)
						.orElseThrow(()->new UsernameNotFoundException("user not found"));
		
		
	}


	public ResponseEntity<Users> addUser(Users user) {
		// TODO Auto-generated method stub
		 if (usersRepo.findByUsername(user.getUsername()).isEmpty()) {
             Users admin = new Users();
             admin.setUsername(user.getUsername());
             admin.setPassword(passwordEncoder.encode(user.getPassword())); // Securely store password
             admin.setRole("ROLE_"+user.getRole().toUpperCase());
             usersRepo.save(admin);
             System.out.println("Default admin user created!");

             return new ResponseEntity<>(HttpStatus.CREATED);
         }
		 else {
			 return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
		 }
	}

}
