package br.edu.ifsp.dsw1.model.dao;

public class RequestDaoFactory {
	public RequestDao factory() {
		return new RequestDaoImpl();
	}
}
