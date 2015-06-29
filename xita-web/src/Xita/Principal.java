package Xita;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import Model.ProdutoOferta;
 

 
@ManagedBean
public class Principal  {
     
    private String option;   
    private ProdutoOferta produto; 
    private List<ProdutoOferta> produtoOferta;
    @ManagedProperty("#{themeService}")
    private ProdutoService service;
     
    @PostConstruct
    public void init() {
    	service = new ProdutoService();
    	produtoOferta = service.getProdutosOfertas();
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
 
    public void setService(ProdutoService service) {
        this.service = service;
    }

	public ProdutoService getService() {
		return service;
	}

	public void setProduto(ProdutoOferta produto) {
		this.produto = produto;
	}

	public void setProdutoOferta(List<ProdutoOferta> produtoOferta) {
		this.produtoOferta = produtoOferta;
	}

}
