package DaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Dao.ClienteDAO;
import Model.Cliente;

@Stateless
public class ClienteDAOImpl implements ClienteDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Cliente persist(Cliente t) {
		if (t.getId() != null){
			return em.merge(t);
		}
		em.persist(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		Query query = em.createQuery("DELETE FROM Cliente c WHERE c.id = "+ id);
		query.executeUpdate();
	}

	@Override
	public void delete(Cliente t) {
		em.remove(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> listAll() {
		Query query = em.createQuery("SELECT c FROM Cliente c");
		return (List<Cliente>) query.getResultList();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return em.find(Cliente.class, id);
		
	}


	@Override
	public void removerCliente(Cliente cliente) {
		em.remove(cliente);		
	}

	@Override
	public void removerCliente(Long id) {
		Query query = em.createQuery("DELETE FROM Cliente c WHERE c.id = "+id);
		query.executeUpdate();
	}

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		if (cliente.getNome() == null || cliente.getCpf_cnpj() == null
				|| cliente.getEmail() == null || cliente.getEndereco() == null
				|| cliente.getDataNascimento() == null
				|| cliente.getSexo() == null || cliente.getSenha() == null) {
			return null;
		}
		
		return this.persist(cliente);
	}

	@Override
	public Long validarCliente(Cliente c) {
		if(c.getEmail().equals(null) && c.getSenha().equals(null)){
			return (long) -1;
		}
		
		Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.email = '" + c.getEmail()+"'");
		List<Cliente> rSenha = (List<Cliente>)query.getResultList();
		
		if(rSenha.get(0).getSenha().equals(c.getSenha())){			
			return rSenha.get(0).getId();
		}
		return (long)-1;
	}

}
