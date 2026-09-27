package com.Gnaneswar.userManagament;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableAspectJAutoProxy
public class UserManagamentApplication {



	public static void main(String[] args) {
		SpringApplication.run(UserManagamentApplication.class, args);
			
		
		
	}

}
