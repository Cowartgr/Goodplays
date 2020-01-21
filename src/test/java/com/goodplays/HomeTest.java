package com.goodplays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.goodplays.controller.HomeController;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeTest
{
	@Autowired
	private HomeController controller;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void contexLoads() throws Exception
	{
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void shouldReturnDefaultMessage() throws Exception 
	{
		this.mockMvc.perform(get("/"))
		.andDo(print())
		.andExpect(status().isOk()).andReturn();
	}
}
