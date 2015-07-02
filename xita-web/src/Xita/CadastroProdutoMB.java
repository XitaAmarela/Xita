package Xita;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.primefaces.model.UploadedFile;

import Dao.ImagemProdutoDAO;
import Dao.ProdutoOfertaDAO;
import Enums.enumTipoProduto;
import Model.ImagemProduto;
import Model.Ofertante;
import Model.ProdutoOferta;

@ManagedBean
public class CadastroProdutoMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 642688437270692289L;
	private ProdutoOferta produto;
	private Date date;
	private Long idProduto;
	ImagemProduto imagem;
    String tipo;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession) context.getExternalContext()
			.getSession(false);
	@EJB
	private ProdutoOfertaDAO cadastroProduto;

	@EJB
	private ImagemProdutoDAO cadastroImagem;

	@Inject
	private Conversation conversation;

	@PostConstruct
	public void init() {
		idProduto = null;
		produto = new ProdutoOferta();
		imagem = new ImagemProduto();
	}

	public void initConversation() {
		if (!FacesContext.getCurrentInstance().isPostback()
				&& conversation.isTransient()) {
			conversation.begin();
		}
	}

	public String salvar(UploadedFile arquivo) {
		Long idClienteSessao = (Long) (session.getAttribute("idClienteSessao") != null ? new Long(
				session.getAttribute("idClienteSessao") + "") : new Long(-1));
		if (idClienteSessao != null)
			if (idClienteSessao != -1) {
				Ofertante ofert = new Ofertante();
				ofert.setId(idClienteSessao);
				produto.setOfertante(ofert);
				produto.setPrecoComDesconto(new BigDecimal(produto.getPreco().doubleValue() * ((100 - produto.getPorcentagemDesconto().doubleValue())/100)));
				produto = cadastroProduto.cadastrarProdutoOferta(produto);
				if (arquivo != null) {

					imagem.setContent(arquivo.getContents());
					imagem.setNome(arquivo.getFileName());
					imagem.setTipo(arquivo.getContentType());
					imagem.setProduto(getProduto());
					imagem = cadastroImagem.cadastrarImagemProduto(imagem);

				}
			}

		if (!conversation.isTransient()) {
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
		if (produto.getId() != null && conversation.isTransient()) {
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
