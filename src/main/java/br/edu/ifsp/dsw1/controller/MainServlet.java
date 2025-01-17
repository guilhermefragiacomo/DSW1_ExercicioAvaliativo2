package br.edu.ifsp.dsw1.controller;

import br.edu.ifsp.dsw1.controller.command.LoggedCommand;
import br.edu.ifsp.dsw1.controller.command.LogoffCommand;
import br.edu.ifsp.dsw1.controller.command.NewUserCommand;
import br.edu.ifsp.dsw1.controller.command.NewUserFormCommand;
import br.edu.ifsp.dsw1.controller.command.ErrorCommand;
import br.edu.ifsp.dsw1.controller.command.GetRequestCommand;
import br.edu.ifsp.dsw1.controller.command.AddRequestFormCommand;
import br.edu.ifsp.dsw1.controller.command.AddRequestCommand;
import br.edu.ifsp.dsw1.controller.command.ChangeRequestCommand;
import br.edu.ifsp.dsw1.controller.command.Command;
import br.edu.ifsp.dsw1.controller.command.DeleteRequestCommand;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		Command command;
		
		if ("logged".equals(action) ) {
			command = new LoggedCommand();
		} else if ("logoff".equals(action)) {
			command = new LogoffCommand();
		} else if ("newUser".equals(action)) {
			command = new  NewUserCommand();
		} else if ("newUserForm".equals(action)) {
			command = new NewUserFormCommand();
		} else if ("addRequest".equals(action)) {
			command = new AddRequestCommand();
		}else if ("deleteRequest".equals(action)) {
			command = new DeleteRequestCommand();
		}else if ("changeRequest".equals(action)) {
			command = new ChangeRequestCommand();
		}else if ("getRequest".equals(action)) {
			command = new GetRequestCommand();
		} else if ("addRequestForm".equals(action)) {
			command = new AddRequestFormCommand();
		} else {
			command = new ErrorCommand();
		}
		
		String view = command.execute(request, response);
		var dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}
}
