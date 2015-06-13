package Dao;

import java.util.List;

import Model.Ofertante;
import Model.ProdutoOferta;

public interface ProdutoOfertaDAO extends GenericaDAO<ProdutoOferta>{

	void removerProdutoOferta(Long id);
	public List<ProdutoOferta> listarProdutoPorOfertante(Ofertante ofertante);
	
}
