package Xita;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Dao.OfertanteDAO;
import Model.Ofertante;

@Named("cadastroOfertanteMB")
@ConversationScoped
public class CadastroOfertanteMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1388746270970762723L;
	private Ofertante ofertante;
	@EJB
	private OfertanteDAO cadastroOfertante;
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void init(){
		ofertante = new Ofertante();
	}

	public String salvar(){
		cadastroOfertante.cadastrarOfertante(ofertante);
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "principal?faces-redirect=true";
	}
	
	public String cancelar(){
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "principal?faces-redirect=true";
	}

	public Ofertante getOfertante() {
		return ofertante;
	}

	public void setOfertante(Ofertante ofertante) {
		if (ofertante.getId() != null && conversation.isTransient()) {
			conversation.begin();
		}
		this.ofertante = ofertante;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
	
}
