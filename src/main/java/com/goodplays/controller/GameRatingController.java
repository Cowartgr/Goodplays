package com.goodplays.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goodplays.entity.RatedGame;
import com.goodplays.repo.RatedGamesRepository;
import com.goodplays.repo.UserRepository;

@RestController
public class GameRatingController
{
	@Autowired
	RatedGamesRepository rgRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/rate")
	public String saveRating(Principal principal,@RequestParam("gameid") int gameid, @RequestParam("rating") int rating)
	{
		if(userRepo.findByUsername(principal.getName()) == null)
			return "Action Failed: User does not exist";
		
		if(rating < 0 || rating > 10)
			return "Action Failed: Invalid rating. Ratings range from 0 - 10";
		
		RatedGame rg = new RatedGame(gameid, principal.getName(),rating);
		
		rgRepo.save(rg);
		
		return "rating has been saved successfully";
	}
}
