package Xita;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import Dao.ProdutoOfertaDAO;
import Model.ProdutoOferta;

@ManagedBean
public class Principal {

	@ManagedProperty(value="#{param.id}")
    private int id;
	private int option;
	private ProdutoOferta produto;
	private List<ProdutoOferta> produtoOferta;
	@Inject
	private Conversation conversation;
	
	
	  FacesContext context = FacesContext.getCurrentInstance();     
	    HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
	
	@EJB
	private ProdutoOfertaDAO produtoOfertaDAO;

	@PostConstruct
	public void init() {
		produtoOferta = produtoOfertaDAO.listAll();
	}
	public void initConversation(){
	    if (!FacesContext.getCurrentInstance().isPostback() 
	      && conversation.isTransient()) {
	      conversation.begin();
	    }
	  }
	
	public String detalhes(){
		session.setAttribute("idPropaganda", id);
		return "detalhesProduto?faces-redirect=true";
		
	}
	
	public String tipoDeProduto(){
		option = produtoOferta.get(1).getTipoProduto().getOpc();
		if (option == 2) {
			return "Restaurantes e Bares";
		}else if (option == 3) {
			return "Sa�de e Beleza";
		}else if (option == 4) {
			return "Fitness";
		}else{
			return "Cursos e Aulas";
		}
	}

	public void todasOfertas() {

	}

	public void restaurantesBares() {

	}

	public void saudeBeleza() {

	}

	public void fitness() {

	}

	public void cursoAulas() {

	}

	public void quemSomos() {

	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FacesContext getContext() {
		return context;
	}

	public void setContext(FacesContext context) {
		this.context = context;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
