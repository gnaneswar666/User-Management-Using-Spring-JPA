package com.Gnaneswar.userManagament.service;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.Gnaneswar.userManagament.model.Users;
import com.Gnaneswar.userManagament.repository.UsersRepository;

@Component
public class AdminUserInitializer {

    @Bean
    public CommandLineRunner createAdminUser(UsersRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findByUsername("admin").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin1234")); // Securely store password
                admin.setRole("ROLE_ADMIN");

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
            if (userRepository.findByUsername("user").isEmpty()) {
                Users admin = new Users();
                admin.setUsername("user");
                admin.setPassword(passwordEncoder.encode("user1234")); // Securely store password
                admin.setRole("ROLE_USER");

                userRepository.save(admin);
                System.out.println("Default admin user created!");
            }
        };
    }
}
