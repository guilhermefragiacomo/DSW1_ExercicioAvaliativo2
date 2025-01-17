package br.edu.ifsp.dsw1.model.dao.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3307/ex_avaliativo2_db";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private DatabaseConnection() {
	}
	
	private static final String RESOURCE = "java:/comp/env/jdbc/mysql";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
/*
	public static Connection getConnection() throws SQLException {
		try {
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource) context.lookup(RESOURCE);
			return dataSource.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return null;
	}*/
}