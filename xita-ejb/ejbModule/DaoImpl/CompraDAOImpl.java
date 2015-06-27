package DaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Dao.CompraDAO;
import Model.Cliente;
import Model.Compra;

@Stateless
public class CompraDAOImpl implements CompraDAO {
	@PersistenceContext
	private EntityManager em;	
	
	@Override
	public Compra persist(Compra t) {
		if (t.getId() != null){
			return em.merge(t);
		}
		em.persist(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		Query query = em.createQuery("DELETE FROM Compra c WHERE c.id = "+id);
		query.executeUpdate();
	}

	@Override
	public void delete(Compra t) {
		if (t != null) {
			em.remove(t);
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compra> listAll() {
		Query query = em.createQuery("SELECT c FROM Compra c");
		return (List<Compra>) query.getResultList();
	}

	@Override
	public Compra buscarPorId(Long id) {
		return em.find(Compra.class, id);
	}

	@Override
	public List<Compra> listarCompraPorCliente(Cliente cliente) {
		Query query = em.createQuery("SELECT c FROM Compra c WHERE c.cliente_id = "+cliente);
		return null;
	}

}
