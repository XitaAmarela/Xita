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
import Model.Cliente;


@ManagedBean(name="validarLogin")
@ConversationScoped
public class ValidarLogin implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6264700980019855212L;
	@EJB
	private ClienteDAO validarCliente;
	@Inject
	private Conversation conversation;
	private String usuario, senha;
	public FacesContext getContext() {
		return context;
	}
	
	Cliente c;
	private Long idClienteSessao;
	
	   FacesContext context = FacesContext.getCurrentInstance();     
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	
	@PostConstruct
	public void init() {
		c = new Cliente();
		idClienteSessao = new Long(-1);
	}
	
	public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() 
	      && conversation.isTransient()) {
	      conversation.begin();
	    }
	  }
	
	public String validar() {
		c.setEmail(getUsuario());
		c.setSenha(getSenha());
		idClienteSessao = validarCliente.validarCliente(c);

		if (idClienteSessao != -1) {
			session.setAttribute("idClienteSessao", idClienteSessao);
			return "principal";
		} else {
			return "destalhesProduto";
		}
	}

	public void sair() {
		if (!conversation.isTransient()) {
			conversation.end();
		}

	}
	
	public String deslogado() {
		idClienteSessao =(Long) (session.getAttribute("idClienteSessao") != null?new Long(session.getAttribute("idClienteSessao")+""):new Long(-1));
		if(idClienteSessao != null)
			if(idClienteSessao != -1)
			return "false";
				return "true";
	}

	public FacesContext getFacesContext() {  
        return FacesContext.getCurrentInstance();  
    }  
      
    public HttpSession getSession() {  
        return (HttpSession) getFacesContext().getExternalContext().getSession(false);  
    }  
      
    public HttpServletRequest getRequestSession() {  
        return (HttpServletRequest) getFacesContext().getExternalContext().getRequest();  
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

	public Long getIdClienteSessao() {
		return idClienteSessao;
	}

	public void setIdClienteSessao(Long idClienteSessao) {
		this.idClienteSessao = idClienteSessao;
	}
	public void setContext(FacesContext context) {
		this.context = context;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


}
