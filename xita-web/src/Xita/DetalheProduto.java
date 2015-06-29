package Xita;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import Model.ProdutoOferta;
 

 
@ManagedBean
public class DetalheProduto  {
     
  
    @ManagedProperty(value="#{param.id}")
    private int id; 
    private ProdutoOferta produto; 
    private ProdutoService service;
    
    
    public ProdutoOferta getProduto() {
		return produto;
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
