package com.goodplays.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Game
{
	private int gameId;
	private String name;
	private String imgURL;
	private List<String> genras;
	
	public Game()
	{
		
	}
	
	public Game(int gameId, String name, String imgURL, List<String> genras)
	{
		this.gameId = gameId;
		this.name = name;
		this.imgURL = imgURL;
		this.genras = genras;
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

	public List<String> getGenras()
	{
		return genras;
	}
	

	public void setGenras(List<String> genras)
	{
		this.genras = genras;
	}
	
	
}
