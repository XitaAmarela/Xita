package Xita;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import Dao.ImagemProdutoDAO;
import Dao.ProdutoOfertaDAO;
import Enums.enumTipoProduto;
import Model.ImagemProduto;
import Model.Ofertante;
import Model.ProdutoOferta;

@Named("cadastroProdutoMB")
@ConversationScoped
public class CadastroProdutoMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 642688437270692289L;
	private ProdutoOferta produto;
	private Date date;
	private Long idProduto;
	ImagemProduto imagem;
	
	
	@EJB
	private ProdutoOfertaDAO cadastroProduto;
	
	@EJB
	private ImagemProdutoDAO cadastroImagem;
	
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void init(){
		idProduto = null;
		produto = new ProdutoOferta();
		imagem = new ImagemProduto();
	}
	
	public String salvar(UploadedFile arquivo){
		Ofertante ofert = new Ofertante();
		ofert.setId(new Long(2));
		produto.setOfertante(ofert);
		produto.setTipoProduto(enumTipoProduto.ALIMENTACAO);
		produto.setPrecoComDesconto(produto.getPreco().multiply(produto.getPorcentagemDesconto().divide(new BigDecimal(100))));
		produto =cadastroProduto.cadastrarProdutoOferta(produto);
		if(arquivo!=null){
			
			imagem.setContent(arquivo.getContents());
			imagem.setNome(arquivo.getFileName());
			imagem.setTipo(arquivo.getContentType());
			imagem.setProduto(getProduto());
			imagem = cadastroImagem.cadastrarImagemProduto(imagem);
								
		}
		
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "listaProdutosAdmin?faces-redirect=true";
	}
	public String cancelar() {
		if (!conversation.isTransient()) {
			conversation.end();
		}
		return "listaProdutosAdmin?faces-redirect=true";
	}

	public ProdutoOferta getProduto() {
		return produto;
	}

	public void setProduto(ProdutoOferta produto) {
		if(produto.getId()!= null && conversation.isTransient()){
			idProduto = imagem.getProduto().getId();
			conversation.begin();			
		}
		this.produto = produto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public ImagemProduto getImagem() {
		return imagem;
	}

	public void setImagem(ImagemProduto imagem) {
		this.imagem = imagem;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoOfertaDAO getCadastroProduto() {
		return cadastroProduto;
	}

	public ImagemProdutoDAO getCadastroImagem() {
		return cadastroImagem;
	}

	public void setCadastroProduto(ProdutoOfertaDAO cadastroProduto) {
		this.cadastroProduto = cadastroProduto;
	}

	public void setCadastroImagem(ImagemProdutoDAO cadastroImagem) {
		this.cadastroImagem = cadastroImagem;
	}
}
