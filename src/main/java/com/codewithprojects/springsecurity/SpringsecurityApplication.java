package com.codewithprojects.springsecurity;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.codewithprojects.springsecurity.entities.Role;
import com.codewithprojects.springsecurity.entities.User;
import com.codewithprojects.springsecurity.repository.UserRepository;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SpringsecurityApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}
@Bean
public ModelMapper modelMapper()
{
	return new ModelMapper();
}
	@Override
	public void run(String... args) throws Exception {

		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if(null==adminAccount) {
			User user = new User();
			user.setEmail("admin@gmail.com");
			user.setRole(Role.ADMIN);
			user.setPassword(passwordEncoder.encode("admin"));
			userRepository.save(user);
		}
	}

}
