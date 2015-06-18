package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ImagemProduto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2634644779295507978L;
	@Id
	@SequenceGenerator(name = "imagem_seq_gen", sequenceName = "imagem_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(generator = "imagem_seq_gen", strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nome;
	private String tipo;
	private byte[] content;
	@OneToOne
	private ProdutoOferta produto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
