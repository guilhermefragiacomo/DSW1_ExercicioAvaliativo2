package br.edu.ifsp.dsw1.model.dao;
import br.edu.ifsp.dsw1.model.entity.User;

public interface UserDao {
	boolean insert(User user);
	User findByEmail(String email);
}
