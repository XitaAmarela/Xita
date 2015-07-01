package Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Compra implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2981746285322222618L;
	@Id
	@SequenceGenerator(name = "compra_seq_gen", sequenceName = "compra_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(generator = "compra_seq_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@NotNull
	private Cliente cliente;
	//@OneToMany (mappedBy="compra")
	//@NotNull
	//private List<ProdutoOferta> produto;
	
	
	@ManyToMany
	@JoinTable(name="compra", joinColumns={@JoinColumn(name="id")}, inverseJoinColumns={@JoinColumn(name="produto_id")})
	private List<ProdutoOferta> produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ProdutoOferta> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoOferta> produto) {
		this.produto = produto;
	}

}
