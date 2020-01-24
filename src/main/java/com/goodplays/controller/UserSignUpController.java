package com.goodplays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodplays.entity.User;
import com.goodplays.repo.UserRepository;

@RestController
public class UserSignUpController
{
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	@RequestMapping("/saveuser")
	public String createNewUser(@RequestParam("username") String userName, @RequestParam("password") String password, @RequestParam("email") String email)
	{
		//check if username is taken
		if(userRepo.findByUsername(userName) != null)
		{
			return "Action Failed: Username taken";
		}
		
		User u = new User(userName,encoder.encode(password),email,"ROLE_USER");
		userRepo.save(u);
		return "User " + userName +" has been successfully created";
	}
	
	
}
