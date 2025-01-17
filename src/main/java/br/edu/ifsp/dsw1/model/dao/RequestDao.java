package br.edu.ifsp.dsw1.model.dao;

import br.edu.ifsp.dsw1.model.entity.Pedido;

public interface RequestDao {
	boolean insert(Pedido pedido);
	boolean delete(Pedido pedido);
	boolean alter(Pedido pedido, Pedido pedido2);
	Pedido findById(int id);
}
