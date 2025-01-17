package br.edu.ifsp.dsw1.model.entity;

import java.util.List;

public class User {
	private String email;
	private String name;
	private String password;
	
	public User(String name, String email, String password) {
		setName(name);
		setEmail(email);
		setPassword(password);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public static boolean autenticate(User userFromSystem, String email, String password) {
		if (userFromSystem != null) {
			return password.equals(userFromSystem.password) && email.equals(userFromSystem.email);
		}
		return false;
	}
}
