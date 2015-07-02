package Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

import Enums.enumTipoProduto;

@Entity
public class ProdutoOferta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5790285835937293809L;

	@Id
	@SequenceGenerator(name = "produto_seq_gen", sequenceName = "produto_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "produto_seq_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String nomeProduto;
	@NotNull
	private String descricao;
	@Enumerated(EnumType.ORDINAL)
	@NotNull
	private enumTipoProduto tipoProduto;
	@NotNull
	private int quantidadeEmEstoque;
	private int quantidadeVendidos;
	private Date tempoPropaganda;
	@NotNull
	private BigDecimal preco;
	@NotNull
	private BigDecimal porcentagemDesconto;
	private BigDecimal precoComDesconto;
	@ManyToOne
	@JoinColumn(name = "ofertante_id")
	@NotNull
	private Ofertante ofertante;
	/*@ManyToOne
	@JoinColumn(name = "compra_id")
	private Compra compra;
*/
	public Ofertante getOfertante() {
		return ofertante;
	}

	public void setOfertante(Ofertante ofertante) {
		this.ofertante = ofertante;
	}

	/*public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}*/

	public int getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public int getQuantidadeVendidos() {
		return quantidadeVendidos;
	}

	public void setQuantidadeVendidos(int quantidadeVendidos) {
		this.quantidadeVendidos = quantidadeVendidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getTempoPropaganda() {
		return tempoPropaganda;
	}

	public void setTempoPropaganda(Date tempoPropaganda) {
		this.tempoPropaganda = tempoPropaganda;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public BigDecimal getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(BigDecimal porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public BigDecimal getPrecoComDesconto() {
		return precoComDesconto;
	}

	public void setPrecoComDesconto(BigDecimal precoComDesconto) {
		precoComDesconto=(getPreco().subtract(getPreco().multiply(porcentagemDesconto.divide(new BigDecimal(100)))));
		this.precoComDesconto = precoComDesconto;
	}

	public enumTipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(enumTipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

}
