package com.Gnaneswar.userManagament.Config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.Gnaneswar.userManagament.Interceptors.LoggingInterceptor;

@Configuration
public class WebConfig  implements WebMvcConfigurer{

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(new LoggingInterceptor())
		.addPathPatterns("/api/**");
	}
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		registry.addMapping("/api/**")
		.allowedOrigins("http://localhost:5173")
		.allowedHeaders("*")
		.allowCredentials(true)
		.allowedMethods("GET","POST","PUT","PATCH","DELETE");
	}

	
	
	
}
