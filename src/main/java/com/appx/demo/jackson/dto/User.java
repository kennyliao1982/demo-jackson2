package com.appx.demo.jackson.dto;

import com.appx.demo.jackson.view.JsonViews;
import com.fasterxml.jackson.annotation.JsonView;

public class User {
	
	@JsonView(JsonViews.Public.class)
	private String name;
	
	@JsonView(JsonViews.Public.class)
	private int age;
	
	@JsonView(JsonViews.Public.class)
	private String title;
	
	@JsonView(JsonViews.Private.class)
	private String password;
	
	public User(){
		
	}
	
	public User(String name, int age, String title, String password) {
		this.name = name;
		this.age = age;
		this.title = title;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
