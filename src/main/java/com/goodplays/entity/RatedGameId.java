package com.goodplays.entity;

import java.io.Serializable;

public class RatedGameId implements Serializable
{
	private int gameid;
	
	private String username;

	public RatedGameId()
	{
		
	}
	
	public RatedGameId(int gameid, String username)
	{
		this.gameid = gameid;
		this.username = username;
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

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + gameid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RatedGameId other = (RatedGameId) obj;
		if (gameid != other.gameid)
			return false;
		if (username == null)
		{
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	

	
	
}
