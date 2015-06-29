package Dao;

import java.util.List;

import Model.Ofertante;
import Model.ProdutoOferta;

public interface ProdutoOfertaDAO extends GenericaDAO<ProdutoOferta>{

	void removerProdutoOferta(ProdutoOferta produto);
	public List<ProdutoOferta> listarProdutoPorOfertante(Long id);
	public List<ProdutoOferta> listAll();
	public ProdutoOferta buscarPorId(Long id);
}
