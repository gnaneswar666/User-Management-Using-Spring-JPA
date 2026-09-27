package com.Gnaneswar.userManagament.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.Gnaneswar.userManagament.filter.JWTAuthFilter;
import com.Gnaneswar.userManagament.service.CustomUserDetailsService;
import com.Gnaneswar.userManagament.util.JWTUtil;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public JWTAuthFilter jwtAuthFilter(
            CustomUserDetailsService service,
            JWTUtil jwtUtil) {
        return new JWTAuthFilter(jwtUtil, service);
    }

    @Bean
    public SecurityFilterChain filterChain(
            HttpSecurity http,
            JWTAuthFilter jwtAuthFilter) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            // Enable CORS in Spring Security
//            .cors(cors -> cors.configurationSource(corsConfigurationSource()))

            .authorizeHttpRequests(auth -> auth
                // Allow browser preflight requests
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                // Public endpoints
                .requestMatchers("/register", "/login").permitAll()

                // Everything else requires JWT authentication
                .anyRequest().authenticated()
            );

        http.addFilterBefore(
            jwtAuthFilter,
            UsernamePasswordAuthenticationFilter.class
        );

        return http.build();
    }

   
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {

        DaoAuthenticationProvider daoAuth =
            new DaoAuthenticationProvider(userDetailsService);

        daoAuth.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(daoAuth);
    }
}