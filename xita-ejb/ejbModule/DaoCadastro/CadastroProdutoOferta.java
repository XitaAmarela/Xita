package DaoCadastro;

import java.util.List;

import Enums.enumTipoProduto;
import Model.Ofertante;
import Model.ProdutoOferta;

public interface CadastroProdutoOferta {
	public ProdutoOferta cadastrarProdutoOferta(ProdutoOferta produtoOferta);
	public List<ProdutoOferta> listarProdutosOfertas();
	public List<ProdutoOferta> listarProdutosOfertasPorOfertante(Ofertante ofertante);
	public List<ProdutoOferta> listarProdutosOfertasPorTipo(int opc);
	void removerProdutoOferta(ProdutoOferta produtoOferta);
	void removerProdutoOferta(Long id);
}
