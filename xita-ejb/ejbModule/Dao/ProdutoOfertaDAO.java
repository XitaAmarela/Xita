package Dao;

import java.util.List;

import Model.Cliente;
import Model.ProdutoOferta;

public interface ProdutoOfertaDAO extends GenericaDAO<ProdutoOferta>{

	void removerProdutoOferta(ProdutoOferta produto);
	public List<ProdutoOferta> listarProdutoPorOfertante(Long id);
	public List<ProdutoOferta> listarProdutoPorTipo(int opc);
	public List<ProdutoOferta> listarProdutosPorCompraDeCliente(Cliente cliente);
	public List<ProdutoOferta> listAll();
	public ProdutoOferta buscarPorId(Long id);
	public ProdutoOferta cadastrarProdutoOferta(ProdutoOferta produtoOferta);
}
