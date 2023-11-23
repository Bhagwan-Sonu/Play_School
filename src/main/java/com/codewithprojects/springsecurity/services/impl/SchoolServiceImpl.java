package com.codewithprojects.springsecurity.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.codewithprojects.springsecurity.dto.SchoolRegistrationDto;
import com.codewithprojects.springsecurity.entities.School_Registeration;
import com.codewithprojects.springsecurity.repository.SchoolRepository;
import com.codewithprojects.springsecurity.services.SchoolService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SchoolServiceImpl implements SchoolService {

	@Autowired
	private SchoolRepository schoolRepository;
	
	@Override
	public void  save(SchoolRegistrationDto schoolRegistrationDto) {
		School_Registeration user1 = new School_Registeration();
		
		user1.setSchool_name(schoolRegistrationDto.getSchool_name());
		user1.setOwner_Chairperson_Name(schoolRegistrationDto.getOwner_Chairperson_Name());
		user1.setAddress(schoolRegistrationDto.getAddress());
		user1.setMobile_No(schoolRegistrationDto.getMobile_No());
		user1.setDistrict(schoolRegistrationDto.getDistrict());
		schoolRepository.save(user1);
	}

}
