package Xita;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import DaoCadastro.CadastroProdutoOferta;
import Model.ProdutoOferta;
 

 
@ManagedBean
public class ListagemProdutosMB {
	
	private String option;
     
    @EJB
    private CadastroProdutoOferta cadastroProduto;
    private List<ProdutoOferta> produtos;
  
    @PostConstruct
    public void init() {
        produtos = cadastroProduto.listarProdutosOfertas();
    }
 
    public String visualizarDetalhesProduto() {
    	//TODO verificar se o mapeamento está correto
        return "detalhesProduto.xhtml?faces-redirect=true";
    }
    
    public String getOption() {
        return option;
    }
 
    public void setOption(String option) {
        this.option = option;
    }
 
 
    public List<ProdutoOferta> getProdutoOferta() {
        return produtos;
    }
 
    public void setProdutoOferta(List<ProdutoOferta> produtos) {
        this.produtos = produtos;
    }
}
