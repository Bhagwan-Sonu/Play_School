package com.codewithprojects.springsecurity.services;

import com.codewithprojects.springsecurity.dto.SchoolRegistrationDto;
import com.codewithprojects.springsecurity.entities.School_Registeration;

public interface SchoolService {

	void save(SchoolRegistrationDto schoolRegistrationDto);
	
}
