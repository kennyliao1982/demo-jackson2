package com.appx.demo.jackson.dto;

import java.util.List;

public class Department {
	
	public Department(){
		
	}
	
	public Department(String name){
		this.name = name;
	}

	private String name;
	
	private List<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
