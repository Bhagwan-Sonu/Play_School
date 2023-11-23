package com.codewithprojects.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithprojects.springsecurity.entities.Role;
import com.codewithprojects.springsecurity.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	
	User findByRole(Role role);
}
