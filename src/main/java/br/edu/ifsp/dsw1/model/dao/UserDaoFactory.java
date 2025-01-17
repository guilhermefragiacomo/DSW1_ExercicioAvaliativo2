package br.edu.ifsp.dsw1.model.dao;

public class UserDaoFactory {
	public UserDao factory() {
		return new UserDaoImpl();
	}
}
