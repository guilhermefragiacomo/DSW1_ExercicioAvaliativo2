package br.edu.ifsp.dsw1.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.FormLoginCommand;
import br.edu.ifsp.dsw1.controller.command.LoginCommand;

@WebServlet("/front.do")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String action = request.getParameter("action");
		
		if ("login".equals(action)) {
			command = new LoginCommand();
		} else if ("getLoginForm".equals(action)) {
			command = new FormLoginCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

}
