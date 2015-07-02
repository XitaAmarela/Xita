package DaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Dao.ProdutoOfertaDAO;
import Model.Cliente;
import Model.Compra;
import Model.Ofertante;
import Model.ProdutoOferta;

@Stateless
public class ProdutoOfertaDAOImpl implements ProdutoOfertaDAO {
	@PersistenceContext
	private EntityManager em;

	@Override
	public ProdutoOferta persist(ProdutoOferta t) {
		if (t.getId() != null) {
			return em.merge(t);
		}
		em.persist(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		Query query = em
				.createQuery("DELETE FROM ProdutoOferta p WHERE p.id = " + id);
		query.executeUpdate();
	}

	@Override
	public void delete(ProdutoOferta t) {
		if (t != null) {
			em.remove(t);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoOferta> listAll() {
		Query query = em.createQuery("SELECT p FROM ProdutoOferta p");
		return (List<ProdutoOferta>) query.getResultList();
	}

	@Override
	public ProdutoOferta buscarPorId(Long id) {
		return em.find(ProdutoOferta.class, id);
	}

	@Override
	public void removerProdutoOferta(ProdutoOferta produto) {
		em.remove(produto);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoOferta> listarProdutoPorOfertante(Long id) {
		Query query = em
				.createQuery("SELECT p FROM ProdutoOferta p WHERE p.ofertante_id = "
						+ id);
		return (List<ProdutoOferta>) query.getResultList();
	}

	

	@Override
	public List<ProdutoOferta> listarProdutosPorCompraDeCliente(Cliente cliente) {
		Query query1 = em
				.createQuery("SELECT p FROM ProdutoOferta p WHERE p.produto_id IN(SELECT c.produto_id FROM Compra c WHERE c.cliente_id"
						+ cliente.getId() + ")");
		/*
		 * Query query = em
		 * .createQuery("SELECT c.produto_id FROM Compra c WHERE c.cliente_id = "
		 * + cliente.getId()); Query query1 = em
		 * .createQuery("SELECT p FROM ProdutoOferta p WHERE p.produto_id = " +
		 * query);
		 */
		return (List<ProdutoOferta>) query1.getResultList();

	}

	@Override
	public ProdutoOferta cadastrarProdutoOferta(ProdutoOferta produtoOferta) {
		if (produtoOferta.getNomeProduto() == null
				|| produtoOferta.getOfertante() == null
				|| produtoOferta.getPreco() == null || produtoOferta.getTempoPropaganda() == null){
			return null;
			
		}
		
		return this.persist(produtoOferta);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ProdutoOferta> listarProdutoPorTipo(Long opc) {
		Query query = em
				.createQuery("SELECT p FROM ProdutoOferta p WHERE p.tipoProduto = '"
						+ opc+ "'");
		return (List<ProdutoOferta>) query.getResultList();
	}

}
