package br.edu.ifsp.dsw1.controller.command;

import java.io.IOException;

import br.edu.ifsp.dsw1.model.dao.RequestDaoFactory;
import br.edu.ifsp.dsw1.model.dao.UserDaoFactory;
import br.edu.ifsp.dsw1.model.entity.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddRequestCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		var nomeCliente = request.getParameter("nomeCliente");
		var enderecoCliente = request.getParameter("enderecoCliente");
		var valor = request.getParameter("valor");
		var descricao = request.getParameter("descricao");
		
		var dao = new RequestDaoFactory().factory();
		var pedido = new Pedido(nomeCliente, enderecoCliente, Double.parseDouble(valor), descricao);
		var saved = dao.insert(pedido);
		
		String message;
		if (saved) 
			message = "Pedido incluído com sucesso.";
		else 
			message = "Erro ao incluír o pedido.";
		
		request.setAttribute("message", message);
		request.setAttribute("saved", saved);
		
		return "add_request.jsp";
	}

}
