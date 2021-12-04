package Model;

import java.util.Date;

public class Movimentacao {
	
	private double valor;
	
	private Date data;
	
	private int quantidadeVendida;
	
	private String nomeDoProduto;
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public Date getData() {
		return this.data;
	}
	
	public void setData() {
		this.data = new Date();
	}
	
	public int getQuantidadeVendida() {
		return this.quantidadeVendida;
	}
	
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	
	public String getNomeDoProduto() {
		return this.nomeDoProduto;
	}
	
	public void setNomeDoProduto(String nomeDoProduto) {
		this.nomeDoProduto = nomeDoProduto;
	}

}
