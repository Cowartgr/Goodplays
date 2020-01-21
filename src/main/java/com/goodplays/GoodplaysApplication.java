package com.goodplays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class GoodplaysApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(GoodplaysApplication.class, args);
	}

	@Bean
	public ObjectMapper getObjectMapper()
	{
		return new ObjectMapper();
	}
}
