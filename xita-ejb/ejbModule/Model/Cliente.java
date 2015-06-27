package Model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;



@Entity
public class Cliente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1380683659990514700L;
	
	@Id
	@SequenceGenerator(name="cliente_seq_gen", sequenceName="cliente_seq", allocationSize=1,initialValue=1)
	@GeneratedValue(generator="cliente_seq_gen",strategy=GenerationType.SEQUENCE)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String cpf_cnpj;
	@NotNull
	private String email;
	private String telefone;
	private String telefoneCelular;
	@NotNull
	private String endereco;
	@NotNull
	private Date dataNascimento;
	@NotNull
	private String sexo;
	@OneToMany (mappedBy="cliente")
	private List<Compra> carrinho;
	
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
	public String getCpf_cnpj() {
		return cpf_cnpj;
	}
	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public List<Compra> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<Compra> carrinho) {
		this.carrinho = carrinho;
	}	
	
}