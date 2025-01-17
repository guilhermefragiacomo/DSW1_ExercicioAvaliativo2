package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		var email = request.getParameter("username");
		var passwd = request.getParameter("password");
		
		var dao = new UserDaoFactory().factory();
		var user = dao.findByEmail(email);
		
		var autorized = User.autenticate(user, passwd);
		
		String view;
		
		if (autorized) {
			var session = request.getSession(true);
			session.setAttribute("user_id", user);
			session.setMaxInactiveInterval(24 * 60 * 60);
			view = "main.do?action=logged";
		} else {
			request.setAttribute("message", "Usuário ou senha inválido.");
			view = "front.do?action=getLoginForm";
		}
		
		return view;
	}

}