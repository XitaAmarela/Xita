package DaoImpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import Dao.OfertanteDAO;
import Model.Cliente;
import Model.Ofertante;
import Model.Sessao;

@Stateless
public class OfertanteDAOImpl implements OfertanteDAO{
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Ofertante persist(Ofertante t) {
		if (t.getId() != null) {
			return em.merge(t);
		}
		em.persist(t);
		return t;
	}

	@Override
	public void delete(Long id) {
		Query query = em
				.createQuery("DELETE FROM Ofertante o WHERE o.id = " + id);
		query.executeUpdate();		
	}

	@Override
	public void delete(Ofertante t) {
		em.remove(t);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ofertante> listAll() {
		Query query = em.createQuery("SELECT o FROM Ofertante o");
		return (List<Ofertante>) query.getResultList();
	}

	@Override
	public Ofertante buscarPorId(Long id) {
		return em.find(Ofertante.class, id);
	}


	@Override
	public List<Ofertante> buscarPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removerOfertante(Ofertante ofertante) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerOfertante(Long id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Ofertante cadastrarOfertante(Ofertante ofertante) {
		if (ofertante.getCnpj() == null || ofertante.getNome() == null
				|| ofertante.getEmail() == null
				|| ofertante.getEndereco() == null){
			return null;
		}
			return this.persist(ofertante);
	}
	@Override
	public Sessao validarOfertante(String email, String senha) {
		if(email.equals(null) && senha.equals(null)){
			return null;
		}
		
		Query query = em.createQuery("SELECT f FROM Ofertante f WHERE f.email = '" + email+"'");
		Ofertante ofertante = (Ofertante) query.getSingleResult();
		Sessao s = new Sessao();
		if(ofertante != null)
		if(ofertante.getSenha().equals(senha)){		
			s.setId(ofertante.getId());
			s.setNome(ofertante.getNome());
			s.setTipoUsuario("OFERTANTE");
			return s;
		}
		return null;
	}

}
