package Xita;

import java.util.Date;
import java.util.UUID;

public class Produtos {
	int id;
	String produto;
	String descricao;
	double valor;
	int quantidade;
	int total;
	String tipo;
	String situacao;
	String getRandomBrand;
	public int getRandomPrice;
	boolean getRandomSoldState;

	public Produtos(String produto, String descricao, int valor, int quantidade,
			int total, String situacao, String tipo) {
		this.produto = produto;
		this.descricao = descricao;
		this.valor = valor;
		this.quantidade = quantidade;
		this.total = total;
		this.tipo = tipo;
		
		

	}



	public String getTipo() {
		return tipo;
	}



	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public String getProduto() {
		return produto;
	}



	public void setProduto(String produto) {
		this.produto = produto;
	}



	public int getQuantidade() {
		return quantidade;
	}



	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	public int getTotal() {
		return total;
	}



	public void setTotal(int total) {
		this.total = total;
	}



	public String getSituacao() {
		return situacao;
	}



	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}



	public int getId() {
		return id;
	}



	public String getDescricao() {
		return descricao;
	}



	public double getValor() {
		return valor;
	}



	public String getGetRandomBrand() {
		return getRandomBrand;
	}

	public int getGetRandomPrice() {
		return getRandomPrice;
	}

	public boolean isGetRandomSoldState() {
		return getRandomSoldState;
	}

	public void setId(int id) {
		this.id = id;
	}



	public void setGetRandomBrand(String getRandomBrand) {
		this.getRandomBrand = getRandomBrand;
	}

	public void setGetRandomPrice(int getRandomPrice) {
		this.getRandomPrice = getRandomPrice;
	}

	public void setGetRandomSoldState(boolean getRandomSoldState) {
		this.getRandomSoldState = getRandomSoldState;
	}
}

	