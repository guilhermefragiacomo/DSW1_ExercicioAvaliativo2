package br.edu.ifsp.dsw1.model.dao;

import java.sql.SQLException;

import br.edu.ifsp.dsw1.model.dao.connection.DatabaseConnection;
import br.edu.ifsp.dsw1.model.entity.Pedido;

public class RequestDaoImpl implements RequestDao {
	private static final String INSERT = "INSERT INTO pedidos (nomeCliente, enderecoEntrega, valor, descricao) VALUES (?, ?, ?, ?)";
	private static final String SELECT_BY_ID = "SELECT * FROM pedidos WHERE idpedidos = ?";
	private static final String DELETE = "DELETE FROM pedidos WHERE idpedidos = ?";
	private static final String UPDATE = "UPDATE pedidos SET nomeCliente = ?, enderecoEntrega = ?, valor = ?, descricao = ? WHERE idpedidos = ?";

	@Override
	public boolean insert(Pedido pedido) {
		int rows = 0;
		if (pedido != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(INSERT)){
				
				statement.setString(1, pedido.getNomeCliente());
				statement.setString(2, pedido.getEndereco());
				statement.setString(3, Double.toString(pedido.getValor()));
				statement.setString(4, pedido.getDescricao());
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public boolean delete(Pedido pedido) {
		int rows = 0;
		if (pedido != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(DELETE)){
				
				statement.setString(1, Integer.toString(pedido.getCodigo()));
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public boolean alter(Pedido pedido, Pedido pedido2) {
		int rows = 0;
		if (pedido != null) {
			try( var connection = DatabaseConnection.getConnection();
				 var statement = connection.prepareStatement(UPDATE)){
				
				statement.setString(1, pedido.getNomeCliente());
				statement.setString(2, pedido.getEndereco());
				statement.setString(3, Double.toString(pedido.getValor()));
				statement.setString(4, pedido.getDescricao());
				statement.setString(5, Integer.toString(pedido.getCodigo()));
				
				rows = statement.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows > 0;
	}

	@Override
	public Pedido findById(int id) {
		Pedido pedido = null;
		try ( var connection = DatabaseConnection.getConnection();
				  var statement = connection.prepareStatement(SELECT_BY_ID)) {
				
				statement.setString(1, Integer.toString(id));
				var resultSet = statement.executeQuery();
				if (resultSet.next()) {
					pedido = new Pedido(resultSet.getString("nomeCliente"),resultSet.getString("enderecoEntrega"),Double.parseDouble(resultSet.getString("valor")),resultSet.getString("descricao"));
					pedido.setCodigo(id);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				pedido = null;
			} 
			
			return pedido;
	}

}
