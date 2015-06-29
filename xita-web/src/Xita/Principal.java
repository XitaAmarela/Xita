package Xita;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import Dao.ProdutoOfertaDAO;
import Model.ProdutoOferta;
 

 
@ManagedBean
@ViewScoped
public class Principal  {
     
    private String option;   
    private ProdutoOferta produto; 
    private List<ProdutoOferta> produtoOferta;
   
   
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
     
    @PostConstruct
    public void init() {
    	produtoOferta = produtoOfertaDAO.listAll();
    }
    
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
    public ProdutoOferta getProduto() {
        return produto;
    }
 
    public void setTheme(ProdutoOferta produto) {
        this.produto = produto;
    }
 
    public List<ProdutoOferta> getProdutoOferta() {
        return produtoOferta;
    }
 

	public void setProduto(ProdutoOferta produto) {
		this.produto = produto;
	}

	public void setProdutoOferta(List<ProdutoOferta> produtoOferta) {
		this.produtoOferta = produtoOferta;
	}

}
