package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class NewUserCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var name = request.getParameter("username");
		var passwd = request.getParameter("password");
		
		var dao = new UserDaoFactory().factory();
		var user = new User(name, passwd);
		var saved = dao.insert(user);
		
		String message;
		if (saved) 
			message = "Usuário cadastrado com sucesso.";
		else 
			message = "Erro ao cadastrar o usuário.";
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "new_user.jsp";
	}

}
