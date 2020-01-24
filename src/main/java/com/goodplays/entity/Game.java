package com.goodplays.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Game
{
	private int gameId;
	private String name;
	private String imgURL;
	private List<String> genres;
	
	public Game()
	{
		
	}
	
	public Game(int gameId, String name, String imgURL, List<String> genras)
	{
		this.gameId = gameId;
		this.name = name;
		this.imgURL = imgURL;
		this.genres = genras;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getGameId()
	{
		return gameId;
	}

	public void setGameId(int gameId)
	{
		this.gameId = gameId;
	}

	public String getImgURL()
	{
		return imgURL;
	}

	public void setImgURL(String imgURL)
	{
		this.imgURL = imgURL;
	}

	public List<String> getGenres()
	{
		return genres;
	}
	

	public void setGenras(List<String> genres)
	{
		this.genres = genres;
	}
	
	
}
