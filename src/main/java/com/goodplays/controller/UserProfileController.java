package com.goodplays.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodplays.entity.Game;
import com.goodplays.entity.RatedGame;
import com.goodplays.entity.User;
import com.goodplays.repo.RatedGamesRepository;
import com.goodplays.repo.UserRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
public class UserProfileController
{
	@Autowired
	private UserRepository repository;

	@Autowired
	private RatedGamesRepository rgRepo;

	@Autowired
	private ObjectMapper mapper;

	@RequestMapping("/profile")
	public User showUserInfo(Principal principal)
	{
		return repository.findByUsername(principal.getName());
	}

	@RequestMapping("/profile/reviews")
	public List<RatedGame> getRatedGames(Principal principal)
			throws JsonMappingException, JsonProcessingException, UnirestException
	{
		ArrayList<RatedGame> games = (ArrayList<RatedGame>) rgRepo.findByUsername(principal.getName());

		for (RatedGame r : games)
		{
			HttpResponse<String> jsonResponse = Unirest.get("https://api.rawg.io/api/games/" + r.getGameid())
					.header("Accept", "application/json").header("User-Agent", "GoodPlays").asString();

			JsonNode json = mapper.readTree(jsonResponse.getBody());

			r.setGameDetails(new Game(r.getGameid(), json.get("name").asText(), json.get("background_image").asText(),
					json.get("genres").findValuesAsText("name")));
		}

		return games;
	}
}
