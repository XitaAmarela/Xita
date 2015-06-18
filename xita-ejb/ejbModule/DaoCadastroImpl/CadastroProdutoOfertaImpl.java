package DaoCadastroImpl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import Dao.ProdutoOfertaDAO;
import DaoCadastro.CadastroProdutoOferta;
import Model.Ofertante;
import Model.ProdutoOferta;

public class CadastroProdutoOfertaImpl implements CadastroProdutoOferta {
	@EJB
	private ProdutoOfertaDAO produtoDAO;

	@Override
	public ProdutoOferta cadastrarProdutoOferta(ProdutoOferta produtoOferta) {
		if (produtoOferta.getNomeProduto() == null
				|| produtoOferta.getDescricao() == null
				|| produtoOferta.getTipoProduto() == null
				|| produtoOferta.getQuantidadeEmEstoque() == 0
				|| produtoOferta.getPreco() == null
				|| produtoOferta.getPorcentagemDesconto() == null
				|| produtoOferta.getOfertante() == null) {
			return null;
		}
		return produtoDAO.persist(produtoOferta);
	}

	@Override
	public List<ProdutoOferta> listarProdutosOfertas() {		
		return produtoDAO.listAll();
	}

	@Override
	public List<ProdutoOferta> listarProdutosOfertasPorOfertante(
			Ofertante ofertante) {
		// TODO LISTAR POR OFERTANTE
		return null;
	}

	@Override
	public void removerProdutoOferta(ProdutoOferta produtoOferta) {
		Date dataAtual = new Date();
		if(produtoOferta.getQuantidadeEmEstoque() <= 0 || produtoOferta.getTempoPropaganda().after(dataAtual) ){
			produtoDAO.removerProdutoOferta(produtoOferta);
		}
	}

	@Override
	public void removerProdutoOferta(Long id) {
		// TODO Auto-generated method stub

	}

}
