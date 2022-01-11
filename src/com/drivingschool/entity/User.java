package com.drivingschool.entity;

public class User {
	
	private String name;
	private String pass;
	private String role;
	
	
	
	public User() {
		super();
	}



	public User(String name, String pass, String role) {
		super();
		this.name = name;
		this.pass = pass;
		this.role = role;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPass() {
		return pass;
	}



	public void setPass(String pass) {
		this.pass = pass;
	}



	@Override
	public String toString() {
		return "User [ name: " + name + "  pass: " + pass + "  role: " + role + "]\n\n";
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
