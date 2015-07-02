package Xita;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import Dao.ProdutoOfertaDAO;
import DaoImpl.ProdutoOfertaDAOImpl;
import Model.ProdutoOferta;
 

 
@ManagedBean(name="listaProdutosAdmin")
public class listaProdutosAdmin {
     
	FacesContext context = FacesContext.getCurrentInstance();     
    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
    
    private List<ProdutoOferta> produtosOfertas;
    
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
     
    @PostConstruct
    public void init() {
       produtosOfertas = produtoOfertaDAO.listarProdutoPorOfertante(new Long(session.getAttribute("idClienteSessao")+""));
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
     
}
