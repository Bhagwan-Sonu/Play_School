package com.codewithprojects.springsecurity.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.codewithprojects.springsecurity.repository.UserRepository;
import com.codewithprojects.springsecurity.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	@Autowired
	private  UserRepository userRepository;
	
	
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				// TODO Auto-generated method stub
				return userRepository.findByEmail(username)
						.orElseThrow(() -> new UsernameNotFoundException("User not found."));
			}
			
		};
	}
}
