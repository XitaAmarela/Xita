package Xita;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import DaoCadastro.CadastroCliente;
import DaoCadastroImpl.CadastroClienteImpl;
import Model.Cliente;

import java.io.Serializable;

@Named("cadastroClienteMB")
@ConversationScoped
public class CadastroClienteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388746270970762723L;
	private Cliente cliente;
	@EJB
	private CadastroClienteImpl cadastroCliente;
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void init(){
		cliente = new Cliente();
	}

	public String salvar(){
		cadastroCliente.cadastrarCliente(cliente);
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "index?faces-redirect=true";
	}
	
	public String cancelar(){
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "index?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		if (cliente.getId() != null && conversation.isTransient()) {
			conversation.begin();
		}
		this.cliente = cliente;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
}
