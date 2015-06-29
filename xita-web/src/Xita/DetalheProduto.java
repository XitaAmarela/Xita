package Xita;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Dao.ProdutoOfertaDAO;
import Model.ProdutoOferta;
 

 
@ManagedBean
public class DetalheProduto  {
     
  
 
	@ManagedProperty(value="#{param.id}")
    private int id; 
    private ProdutoOferta produto; 
    @EJB
    private ProdutoOfertaDAO produtoOfertaDAO;
     
    
    
    public ProdutoOferta getProduto() {
    	
		return produtoOfertaDAO.buscarPorId(new Long(id));
	}


	public void setProduto(ProdutoOferta produto) {
		this.produto = produto;
	}
	
   
    
 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
