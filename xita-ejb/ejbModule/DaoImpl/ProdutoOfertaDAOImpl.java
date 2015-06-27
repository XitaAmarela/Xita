package DaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Dao.ProdutoOfertaDAO;
import Model.Ofertante;
import Model.ProdutoOferta;

@Stateless
public class ProdutoOfertaDAOImpl implements ProdutoOfertaDAO{
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
		Query query = em.createQuery("DELETE FROM ProdutoOferta p WHERE p.id = "+id);
		query.executeUpdate();
	}

	@Override
	public void delete(ProdutoOferta t) {
		if(t!=null){
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
		Query query = em.createQuery("SELECT p FROM ProdutoOferta p WHERE ofertante_id = "+ id);
		return (List<ProdutoOferta>) query.getResultList();
	}

}
