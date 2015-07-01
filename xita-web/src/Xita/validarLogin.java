package Xita;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Dao.ClienteDAO;
import Model.Cliente;

@Named("validarLogin")
@ConversationScoped
public class validarLogin implements Serializable {

	@EJB
	private ClienteDAO validarCliente;
	@Inject
	private Conversation conversation;
	Cliente c;
	private Long idClienteSessao;

	@PostConstruct
	public void init() {
		c = new Cliente();
	}

	public String validar() {
		
		idClienteSessao = validarCliente.validarCliente(c);		
		
		if (idClienteSessao!=-1) {
			return "principal?faces-redirect=true";
		} else {
			return "destalhesProduto?faces-redirect=false";
		}
	}
	
	public void desconectarConta(){
		if (!conversation.isTransient()) {
			conversation.end();
		}
	}



	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Cliente getC() {
		return c;
	}

	public void setC(Cliente c) {
		if (c.getSenha() != null && c.getEmail() != null
				&& conversation.isTransient()) {
			conversation.begin();
		}
		this.c = c;
	}

	public Long getIdClienteSessao() {
		return idClienteSessao;
	}

	public void setIdClienteSessao(Long idClienteSessao) {
		this.idClienteSessao = idClienteSessao;
	}

}
