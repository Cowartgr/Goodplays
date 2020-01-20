package com.goodplays.entity;

import java.util.List;

public class GameSearchResults
{
	private int resultCount;
	private String nextPage;
	private String prevPage;
	private List<Game> results;
	
	public GameSearchResults()
	{
		
	}

	public GameSearchResults(int resultCount, String nextPage, String prevPage, List<Game> results)
	{
		this.resultCount = resultCount;
		this.nextPage = nextPage;
		this.prevPage = prevPage;
		this.results = results;
	}

	public int getResultCount()
	{
		return resultCount;
	}

	public void setResultCount(int resultCount)
	{
		this.resultCount = resultCount;
	}

	public String getNextPage()
	{
		return nextPage;
	}

	public void setNextPage(String nextPage)
	{
		this.nextPage = nextPage;
	}

	public String getPrevPage()
	{
		return prevPage;
	}

	public void setPrevPage(String prevPage)
	{
		this.prevPage = prevPage;
	}

	public List<Game> getResults()
	{
		return results;
	}

	public void setResults(List<Game> results)
	{
		this.results = results;
	}
	
	
	
	
	
	
}
