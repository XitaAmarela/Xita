package Xita;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import Dao.ProdutoOfertaDAO;
import DaoImpl.ProdutoOfertaDAOImpl;
import Model.ProdutoOferta;
 

 
@ManagedBean(name="produtoService")
public class ProdutoService {
     
    private List<ProdutoOferta> produtosOfertas;
    private ProdutoOfertaDAOImpl produtoOfertaDao;
     
    @PostConstruct
    public void init() {
    	produtoOfertaDao = new ProdutoOfertaDAOImpl();
       produtosOfertas = produtoOfertaDao.listAll();
    }

	public List<ProdutoOferta> getProdutosOfertas() {
		return produtosOfertas;
	}

	public void setProdutosOfertas(List<ProdutoOferta> produtosOfertas) {
		this.produtosOfertas = produtosOfertas;
	}

	public ProdutoOfertaDAOImpl getProdutoOfertaDao() {
		return produtoOfertaDao;
	}

	public void setProdutoOfertaDao(ProdutoOfertaDAOImpl produtoOfertaDao) {
		this.produtoOfertaDao = produtoOfertaDao;
	}
     
}
