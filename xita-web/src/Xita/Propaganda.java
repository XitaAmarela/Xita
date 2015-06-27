package Xita;

import java.util.Date;
import java.util.UUID;

public class Propaganda {
	int id;
	String titulo;
	String tipo;
	int estoque;
	int vendidos;
	String descricao;
	Date Trestante;
	double valor;
	double desconto;
	String getRandomBrand;
	public int getRandomPrice;
	boolean getRandomSoldState;

	public Propaganda(String titulo, String tipo, int estoque, int vendidos,
			String descricao, double valor, double desconto) {
		this.titulo = titulo;
		this.tipo = tipo;
		this.estoque = estoque;
		this.vendidos = vendidos;
		this.descricao = descricao;
		this.valor = valor;
		this.desconto = desconto;
		

	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public int getEstoque() {
		return estoque;
	}

	public int getVendidos() {
		return vendidos;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getTrestante() {
		return Trestante;
	}

	public double getValor() {
		return valor;
	}

	public double getDesconto() {
		return desconto;
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public void setVendidos(int vendidos) {
		this.vendidos = vendidos;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setTrestante(Date trestante) {
		Trestante = trestante;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
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

	