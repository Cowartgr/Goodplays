package com.goodplays.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.goodplays.entity.Game;
import com.goodplays.entity.GameSearchResults;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

@RestController
@RequestMapping("/games")
public class GameInfoController
{
	@Autowired
	private ObjectMapper mapper;
	
	@GetMapping("/{gameId}")
	public Game getGameInfo(@PathVariable("gameId") String gameId) throws UnirestException, JsonMappingException, JsonProcessingException 
	{	
		HttpResponse<String> jsonResponse = Unirest.get("https://api.rawg.io/api/games/" + gameId)
				  .header("Accept", "application/json")
				  .header("User-Agent", "GoodPlays")
				  .asString();
		
		JsonNode json = mapper.readTree(jsonResponse.getBody());	 
		
		return new Game(gameId, json.get("name").asText(), json.get("background_image").asText() ,json.get("genres").findValuesAsText("name"));
	}
 	
	@GetMapping("/search")
	public GameSearchResults searchByGameName(@RequestParam("name") String name) throws UnirestException, JsonMappingException, JsonProcessingException
	{
		HttpResponse<String> jsonResponse = Unirest.get("https://api.rawg.io/api/games?search=" + name)
				  .header("Accept", "application/json")
				  .header("User-Agent", "GoodPlays")
				  .asString();
		
		JsonNode json = mapper.readTree(jsonResponse.getBody());
		List<Game> results = new ArrayList<>();
		
		for(JsonNode n : json.get("results"))
		{			
			results.add(new Game(n.get("id").asText(),n.get("name").asText(), n.get("background_image").asText(),n.get("genres").findValuesAsText("name")));
		}
		
		return new GameSearchResults(json.get("count").asInt(), json.get("next").asText(), json.get("previous").asText(),results);	 
	}
	
}
