package Xita;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Dao.ProdutoOfertaDAO;
import DaoImpl.ProdutoOfertaDAOImpl;
import Model.ProdutoOferta;
 

 
@ManagedBean(name="produtoService")
public class ProdutoService {
     
    private List<ProdutoOferta> produtosOfertas;
    
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
     
    @PostConstruct
    public void init() {
       produtosOfertas = produtoOfertaDAO.listAll();
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
