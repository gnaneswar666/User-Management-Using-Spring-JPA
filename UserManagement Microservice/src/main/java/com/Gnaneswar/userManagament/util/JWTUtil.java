package com.Gnaneswar.userManagament.util;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	
	private final String SECRET="hey this is my secret key 1234567890@#1";
	private final SecretKey key=Keys.hmacShaKeyFor(SECRET.getBytes());
	private final long expiration=1000*60*60;
	public String getJWTToken(String username) {
		return Jwts.builder().setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+expiration))
				.signWith(key, SignatureAlgorithm.HS256)
				.compact();
	}
	public String getUserName(String token) {
		return getClaim(token).getSubject();
	}
	public boolean validateToken(String username,UserDetails details ,String token) {
		return username.equals(details.getUsername())&&!getClaim(token).getExpiration().before(new Date());
	}
	public Claims getClaim(String token) {
		return Jwts.parserBuilder().setSigningKey(key)
			.build()
			.parseClaimsJws(token)
			.getBody();
	}
	 
}
