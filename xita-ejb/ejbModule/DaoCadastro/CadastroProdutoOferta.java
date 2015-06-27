package DaoCadastro;

import java.util.List;

import Model.Ofertante;
import Model.ProdutoOferta;

public interface CadastroProdutoOferta {
	public ProdutoOferta cadastrarProdutoOferta(ProdutoOferta produtoOferta);
	public List<ProdutoOferta> listarProdutosOfertas();
	public List<ProdutoOferta> listarProdutosOfertasPorOfertante(Ofertante ofertante);
	void removerProdutoOferta(ProdutoOferta produtoOferta);
	void removerProdutoOferta(Long id);
}
