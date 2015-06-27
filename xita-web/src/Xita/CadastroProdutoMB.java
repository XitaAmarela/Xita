package Xita;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import DaoCadastro.CadastroImagemProduto;
import DaoCadastro.CadastroProdutoOferta;
import Model.ImagemProduto;
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
	private CadastroProdutoOferta cadastroProduto;
	
	@EJB
	private CadastroImagemProduto cadastroImagem;
	
	@Inject
	private Conversation conversation;
	
	@PostConstruct
	public void init(){
		idProduto = null;
		produto = new ProdutoOferta();
		imagem = new ImagemProduto();
	}
	
	private String salvar(UploadedFile arquivo){
		if(arquivo!=null){
			
			imagem.setContent(arquivo.getContents());
			imagem.setNome(arquivo.getFileName());
			imagem.setTipo(arquivo.getContentType());
			imagem = cadastroImagem.cadastrarImagemProduto(imagem);
			imagem.setProduto(getProduto());					
		}
		cadastroProduto.cadastrarProdutoOferta(produto);
		if(conversation.isTransient()){
			conversation.end();
		}
		return "listagemProduto?faces-redirect=true";
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

	public CadastroProdutoOferta getCadastroProduto() {
		return cadastroProduto;
	}

	public void setCadastroProduto(CadastroProdutoOferta cadastroProduto) {
		this.cadastroProduto = cadastroProduto;
	}

	public CadastroImagemProduto getCadastroImagem() {
		return cadastroImagem;
	}

	public void setCadastroImagem(CadastroImagemProduto cadastroImagem) {
		this.cadastroImagem = cadastroImagem;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}
}
