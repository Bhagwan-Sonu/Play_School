package com.codewithprojects.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithprojects.springsecurity.dto.JWTAuthenticationResponse;
import com.codewithprojects.springsecurity.dto.RefreshTokenRequest;
import com.codewithprojects.springsecurity.dto.SignUpRequest;
import com.codewithprojects.springsecurity.dto.SigninRequest;
import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.services.AuthenticationService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private AuthenticationService authenticationService;
	
	@PostMapping("/signup")
	public ResponseEntity<User> signup(@RequestBody SignUpRequest signUpRequest){
		return ResponseEntity.ok(authenticationService.signup(signUpRequest));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<JWTAuthenticationResponse> signin(@RequestBody SigninRequest signinRequest){
		return ResponseEntity.ok(authenticationService.signin(signinRequest));
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<JWTAuthenticationResponse> refresh(@RequestBody RefreshTokenRequest refreshTokenRequest){
		return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
	}
}
