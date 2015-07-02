package Xita;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import Dao.ImagemProdutoDAO;
import Dao.ProdutoOfertaDAO;
import DaoImpl.ProdutoOfertaDAOImpl;
import Model.ImagemProduto;
import Model.ProdutoOferta;
 

 
@ManagedBean(name="listaProdutosCliente")
public class ListaProdutosCliente {
     
    private List<ProdutoOferta> produtosOfertas;
    private List<ImagemProduto>imagensOfertas;
    @EJB
    private ImagemProdutoDAO imagemDAO;
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
    
     
    @PostConstruct
    public void init() {
    	setImagensOfertas(imagemDAO.listAll());
       produtosOfertas = produtoOfertaDAO.listAll();
    }
    
    public void excluirProdutoOfertante(ProdutoOferta produto){    	
    	imagemDAO.delete(produto.getId());
    	produtoOfertaDAO.delete(produto.getId());
    	imagensOfertas = imagemDAO.listAll();
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

	public List<ImagemProduto> getImagensOfertas() {
		return imagensOfertas;
	}

	public void setImagensOfertas(List<ImagemProduto> imagensOfertas) {
		this.imagensOfertas = imagensOfertas;
	}


}
