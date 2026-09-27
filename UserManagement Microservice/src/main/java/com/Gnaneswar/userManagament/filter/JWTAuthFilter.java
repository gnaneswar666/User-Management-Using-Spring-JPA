package com.Gnaneswar.userManagament.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.Gnaneswar.userManagament.service.CustomUserDetailsService;
import com.Gnaneswar.userManagament.util.JWTUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthFilter extends OncePerRequestFilter {

	  private final JWTUtil util;
	    private final CustomUserDetailsService service;

	    public JWTAuthFilter(JWTUtil util, CustomUserDetailsService service) {
	        this.util = util;
	        this.service = service;
	    }
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String authHeader=request.getHeader("Authorization");
		String username=null;
		String token=null;
		if(authHeader!=null&&authHeader.startsWith("Bearer ")) {
			token=authHeader.substring(7);
			username=util.getUserName(token);
		}
		
		if(username!=null&&SecurityContextHolder.getContext().getAuthentication()==null) {
		
			UserDetails details=service.loadUserByUsername(username);
			if(util.validateToken(username, details, token)) {
				UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(details, null,details.getAuthorities());
				auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(auth);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
