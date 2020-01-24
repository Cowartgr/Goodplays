package com.goodplays.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@IdClass(RatedGameId.class)
@Table(name = "rated_games")
public class RatedGame
{
	@Id
	@Column(name = "gameid")
	private int gameid;
	
	@Transient
	private Game gameDetails;
	
	@Id
	@Column(name = "username")
	private String username;
	
	@Column(name= "rating")
	private int rating;

	public RatedGame()
	{
		
	}
	
	public RatedGame(int gameid, String username, int rating)
	{
		this.gameid = gameid;
		this.username = username;
		this.rating = rating;
	}

	public int getGameid()
	{
		return gameid;
	}

	public void setGameid(int gameid)
	{
		this.gameid = gameid;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getRating()
	{
		return rating;
	}

	public void setRating(int rating)
	{
		this.rating = rating;
	}
	
	public Game getGameDetails()
	{
		return gameDetails;
	}
	
	public void setGameDetails(Game gameDetails)
	{
		 this.gameDetails = gameDetails;
	}

	@Override
	public String toString()
	{
		return "GameCatalogItem [gameid=" + gameid +  ", rating=" + rating + "]";
	}

	
	
}
