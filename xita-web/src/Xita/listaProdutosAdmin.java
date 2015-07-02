package Xita;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import Dao.ProdutoOfertaDAO;
import Model.ProdutoOferta;
 

 
@ManagedBean
public class listaProdutosAdmin {
     
	FacesContext context = FacesContext.getCurrentInstance();     
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    
    private List<ProdutoOferta> produtosOfertas = new ArrayList<ProdutoOferta>();
    
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
    @Inject
	private Conversation conversation; 
    
    @PostConstruct
    public void init() {
       produtosOfertas = produtoOfertaDAO.listarProdutoPorOfertante(new Long(session.getAttribute("idClienteSessao")+""));
    }
    public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() 
	      && conversation.isTransient()) {
	      conversation.begin();
	    }
	  }
	public List<ProdutoOferta> getProdutosOfertas() {
		return produtosOfertas;
	}

	public void setProdutosOfertas(List<ProdutoOferta> produtosOfertas) {
		this.produtosOfertas = produtosOfertas;
	}

	public ProdutoOfertaDAO getProdutoOfertaDAO() {
		return produtoOfertaDAO;
	}

	public void setProdutoOfertaDAO(ProdutoOfertaDAO produtoOfertaDao) {
		this.produtoOfertaDAO = produtoOfertaDao;
	}
	public FacesContext getContext() {
		return context;
	}
	public void setContext(FacesContext context) {
		this.context = context;
	}
	public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}
	public Conversation getConversation() {
		return conversation;
	}
	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
     
}
