package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.User;

public class UserDaoImpl implements UserDao {
	private static final String CREATE_TABLE = "CREATE TABLE tb_user ("
			+ "    name VARCHAR(150) NOT NULL PRIMARY KEY,"
			+ "    password VARCHAR(128)"
			+ ");";
	private static final String INSERT = "INSERT INTO tb_user (name, password) VALUES (?, ?)";
	private static final String SELECT_BY_EMAIL = "SELECT * FROM tb_user WHERE name = ?";

	@Override
	public boolean insert(User user) {
		int rows = 0;
		if (user != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, user.getName());
				statement.setString(2, user.getPassword());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public User findByEmail(String email) {
		User user = null;
		try ( var connection = DatabaseConnection.getConnection();
			  var statement = connection.prepareStatement(SELECT_BY_EMAIL)) {
			
			statement.setString(1, email);
			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				user = new User(resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			user = null;
		} 
		
		return user;
	}
}
