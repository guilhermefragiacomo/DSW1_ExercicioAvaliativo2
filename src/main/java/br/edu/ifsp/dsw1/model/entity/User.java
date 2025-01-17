package br.edu.ifsp.dsw1.model.entity;

import java.util.List;

public class User {
	private String name;
	private String password;
	
	public User(String name, String password) {
		setName(name);
		setPassword(password);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean autenticate(User userFromSystem, String password) {
		if (userFromSystem != null) {
			return password.equals(userFromSystem.password);
		}
		return false;
	}
}
