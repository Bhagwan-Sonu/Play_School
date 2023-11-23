package com.codewithprojects.springsecurity.services.impl;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.codewithprojects.springsecurity.dto.JWTAuthenticationResponse;
import com.codewithprojects.springsecurity.dto.RefreshTokenRequest;
import com.codewithprojects.springsecurity.dto.SignUpRequest;
import com.codewithprojects.springsecurity.dto.SigninRequest;
import com.codewithprojects.springsecurity.entities.Role;
import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.repository.UserRepository;
import com.codewithprojects.springsecurity.services.AuthenticationService;
import com.codewithprojects.springsecurity.services.JWTService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authticationManager;
	
	@Autowired
	private JWTService jwtService;
	
	public User signup(SignUpRequest signUpRequest) {
		User user = new User();
		
		user.setEmail(signUpRequest.getEmail());
		user.setRole(Role.USER);
		user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
		
		return userRepository.save(user);
	}
	
	public JWTAuthenticationResponse signin(SigninRequest signinRequest) {
		authticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),
				signinRequest.getPassword()));
		
		var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid Email or Password"));
		var jwt = jwtService.generateToken(user);
		var refreshToken = jwtService.generateRefreshToken(new HashMap<>(), user);
		
		JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();
		
		jwtAuthenticationResponse.setToken(jwt);
		jwtAuthenticationResponse.setRefreshToken(refreshToken);
		return jwtAuthenticationResponse;
		
	}
	
	public JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		String userEmail = jwtService.extractUserName(refreshTokenRequest.getToken());
		User user = userRepository.findByEmail(userEmail).orElseThrow();
		if(jwtService.isTokenValid(refreshTokenRequest.getToken(), user)) {
			var jwt = jwtService.generateToken(user);
			
			JWTAuthenticationResponse jwtAuthenticationResponse = new JWTAuthenticationResponse();
			
			jwtAuthenticationResponse.setToken(jwt);
			jwtAuthenticationResponse.setRefreshToken(refreshTokenRequest.getToken());
			return jwtAuthenticationResponse;
		}
		return null;
	}
	
	
	
}
