package Xita;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Dao.ClienteDAO;
import Dao.OfertanteDAO;
import Model.Cliente;
import Model.Sessao;

@ManagedBean
public class ValidarLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6264700980019855212L;
	@EJB
	private ClienteDAO validarCliente;
	@EJB
	private OfertanteDAO validarOfertante;
	@Inject
	private Conversation conversation;

	public FacesContext getContext() {
		return context;
	}

	Cliente c;
	private Sessao sessao;

	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) context.getExternalContext()
			.getSession(false);

	@PostConstruct
	public void init() {
		c = new Cliente();
		sessao = new Sessao();
	}

	public void initConversation() {
		if (!FacesContext.getCurrentInstance().isPostback()
				&& conversation.isTransient()) {
			conversation.begin();
		}
	}

	public String validar() {
		try {
			sessao = validarCliente.validarCliente(c.getEmail(), c.getSenha());
		} catch (Exception e) {
			// TODO: handle exception
		}
		if (sessao == null)
			try {
				sessao = validarOfertante.validarOfertante(c.getEmail(),
						c.getSenha());
			} catch (Exception e) {
				// TODO: handle exception
			}

		if (sessao.getId() != -1) {
			session.setAttribute("sessao", sessao);
			if(sessao.getTipoUsuario().equals("CLIENTE")){
				return "listaProdutosCliente?faces-redirect=true";

			}else{
				
				return "listaProdutosAdmin?faces-redirect=true";
			}
		} else {
			return "principal?faces-redirect=true";
		}
	}

	public void sair() {
		if (!conversation.isTransient()) {
			conversation.end();
		}

	}

	public String deslogado() {
		sessao = (Sessao) (session.getAttribute("sessao") != null ? session
				.getAttribute("sessao") : new Sessao());
		if (sessao != null)
			if (sessao.getId() != null)
				return "false";
		return "true";
	}

	public FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	public HttpSession getSession() {
		return (HttpSession) getFacesContext().getExternalContext().getSession(
				false);
	}

	public HttpServletRequest getRequestSession() {
		return (HttpServletRequest) getFacesContext().getExternalContext()
				.getRequest();
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
		this.c = c;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
