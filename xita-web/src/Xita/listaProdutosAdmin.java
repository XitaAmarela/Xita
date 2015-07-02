package Xita;


import java.util.ArrayList;
import java.util.Date;
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
import Model.Sessao;
 

 
@ManagedBean
public class listaProdutosAdmin {
     
	FacesContext context = FacesContext.getCurrentInstance();     
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    
    private List<ProdutoOferta> produtosOfertas = new ArrayList<ProdutoOferta>();
    
   
	@EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
    @Inject
	private Conversation conversation;
    private Date d = new Date();
	private int i = 0;
    
    @PostConstruct
    public void init() {
    	Sessao s = (Sessao) session.getAttribute("sessao");
       produtosOfertas = produtoOfertaDAO.listarProdutoPorOfertante(s.getId());
    }
    public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() 
	      && conversation.isTransient()) {
	      conversation.begin();
	    }
	  }
    public Date tempoRestante(long id) {
		Long mm = new Date().getTime();
		for (int i = 0; i < produtosOfertas.size(); i++) {
			mm = new Long(produtosOfertas.get(i).getTempoPropaganda().getTime()
					- new Date().getTime());
		}

		Date a = new Date(mm);
		i++;
		if (i == produtosOfertas.size())
			i = 0;
		setD(a);
		return getD();
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
	public Date getD() {
		return d;
	}
	public void setD(Date d) {
		this.d = d;
	}
	 public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
     
}
