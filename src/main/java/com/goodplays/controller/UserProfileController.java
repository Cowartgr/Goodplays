package com.goodplays.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodplays.entity.User;
import com.goodplays.repo.UserRepository;

@RestController
public class UserProfileController
{
	@Autowired
    private UserRepository repository; 
	
	@RequestMapping("/profile")
	public User showUserInfo(Principal principal)
	{
		return repository.findByUsername(principal.getName());
	}
}
