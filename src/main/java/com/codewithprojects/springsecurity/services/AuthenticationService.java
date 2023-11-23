package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.dto.JWTAuthenticationResponse;
import com.codewithprojects.springsecurity.dto.RefreshTokenRequest;
import com.codewithprojects.springsecurity.dto.SignUpRequest;
import com.codewithprojects.springsecurity.dto.SigninRequest;
import com.codewithprojects.springsecurity.entities.User;

public interface AuthenticationService {

	User signup(SignUpRequest signUpRequest);
	
	JWTAuthenticationResponse signin(SigninRequest signinRequest);
	
	JWTAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
