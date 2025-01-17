package br.edu.ifsp.dsw1.model.entity;

public class Pedido {
	private int codigo;
	private String nomeCliente;
	private String endereco;
	private double valor;
	private String descricao;
	
	public Pedido(String nomeCliente, String endereco, double valor, String descricao) {
		setNomeCliente(nomeCliente);
		setEndereco(endereco);
		setValor(valor);
		setDescricao(descricao);
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
