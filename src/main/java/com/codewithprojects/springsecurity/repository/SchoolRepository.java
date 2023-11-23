package com.codewithprojects.springsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithprojects.springsecurity.entities.School_Registeration;

public interface SchoolRepository extends JpaRepository<School_Registeration, Long> {

//	School_Registeration findByEmail(String email);
}
