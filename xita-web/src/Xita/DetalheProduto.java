package Xita;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Dao.ProdutoOfertaDAO;
import Model.ProdutoOferta;
 

 
@ManagedBean
public class DetalheProduto  {
     
  
 
	
    private ProdutoOferta produto; 
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
     
    FacesContext context = FacesContext.getCurrentInstance();     
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);

    
    public ProdutoOferta getProduto() {
    	this.produto =  produtoOfertaDAO.buscarPorId(new Long( session.getAttribute("idPropaganda")+""));
		return produto;
	}


	public void setProduto(ProdutoOferta produto) {
		this.produto = produto;
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
	
}
