package com.goodplays.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User
{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "USERID")
	private int userId;
	
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "ROLE", nullable = false)
	private String role;

	@Column(name = "ENABLED", nullable = false)
	private int enabled;

	public User()
	{

	}

	public User(String username, String password, String email, String role)
	{
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.enabled = 1;
	}


	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int isEnabled()
	{
		return enabled;
	}
	
	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public void setEnabled(int enabled)
	{
		this.enabled = enabled;
	}

	@Override
	public String toString()
	{
		return "User [username=" + username + ", password=" + password + ", email=" + email + ", role=" + role
				+ ", enabled=" + enabled + "]";
	}

	
}
