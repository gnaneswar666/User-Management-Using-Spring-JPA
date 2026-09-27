package com.Gnaneswar.userManagament.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gnaneswar.userManagament.model.AuthRequest;
import com.Gnaneswar.userManagament.util.JWTUtil;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class LoginController {

	@Autowired
	AuthenticationManager auth;
	@Autowired
	JWTUtil jwtutil;
	@PostMapping("/login")
	public String getToken(@RequestBody AuthRequest request) {
		
		try {
			auth.authenticate(
					
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
					);
			return jwtutil.getJWTToken(request.getUsername());
			
		}
		catch(Exception e) {
			throw e;
		}
	}
}
