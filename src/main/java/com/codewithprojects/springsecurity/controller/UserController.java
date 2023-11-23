package com.codewithprojects.springsecurity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codewithprojects.springsecurity.dto.SchoolRegistrationDto;
import com.codewithprojects.springsecurity.entities.School_Registeration;
import com.codewithprojects.springsecurity.services.SchoolService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

	@Autowired
	private SchoolService schoolService;
	
	@GetMapping
	public ResponseEntity<String> sayHello(){
		return ResponseEntity.ok("Hi user");
	}
	
	@GetMapping("/registration")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        SchoolRegistrationDto user = new SchoolRegistrationDto();
        model.addAttribute("registration", user);
        return "registration";
    }
	
	@PostMapping("/registration/save")
	public String registerUserAccount(@RequestBody SchoolRegistrationDto schoolRegistrationDto) {
		
//		School_Registeration existingUser = schoolService.findUserByEmail(schoolRegistrationDto.getEmail());

//        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
//            return "There is already an account registered with the same email";
//        }

//        if(result.hasErrors()){
//            model.addAttribute("registration", schoolRegistrationDto);
//            return "/registration";
//        }
		
        schoolService.save(schoolRegistrationDto);
		return "registered successfully";
	}
	
//	@PostMapping("/register")
//	public ResponseEntity<School_Registeration> register(@RequestBody SchoolRegistrationDto schoolRegistrationDto){
//		School_Registeration savedSchool = schoolService.register(schoolRegistrationDto);
//		return new ResponseEntity<>(savedSchool, HttpStatus.CREATED);
//	}
}
