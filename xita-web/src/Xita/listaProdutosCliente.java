package Xita;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Dao.ImagemProdutoDAO;
import Dao.ProdutoOfertaDAO;
import DaoImpl.ProdutoOfertaDAOImpl;
import Model.ProdutoOferta;
 

 
@ManagedBean(name="listaProdutosCliente")
public class listaProdutosCliente {
     
    private List<ProdutoOferta> produtosOfertas;
    
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
    @EJB
    private ImagemProdutoDAO imagemProdutoDAO;
     
    @PostConstruct
    public void init() {
       produtosOfertas = produtoOfertaDAO.listAll();
       imagemProdutoDAO = (ImagemProdutoDAO) imagemProdutoDAO.listAll();
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

	public ImagemProdutoDAO getImagemProdutoDAO() {
		return imagemProdutoDAO;
	}

	public void setImagemProdutoDAO(ImagemProdutoDAO imagemProdutoDAO) {
		this.imagemProdutoDAO = imagemProdutoDAO;
	}
     
}
