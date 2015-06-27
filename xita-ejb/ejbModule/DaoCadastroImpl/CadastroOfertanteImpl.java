package DaoCadastroImpl;

import java.util.List;

import javax.ejb.EJB;

import Dao.OfertanteDAO;
import DaoCadastro.CadastroOfertante;
import Model.Ofertante;

public class CadastroOfertanteImpl implements CadastroOfertante {
	@EJB
	private OfertanteDAO ofertanteDAO;

	@Override
	public Ofertante cadastrarOfertante(Ofertante ofertante) {
		if (ofertante.getCnpj() == null || ofertante.getNome() == null
				|| ofertante.getEmail() == null
				|| ofertante.getEndereco() == null){
			return null;
		}
			return ofertanteDAO.persist(ofertante);
	}

	@Override
	public List<Ofertante> listarOfertante() {		
		return ofertanteDAO.listAll();
	}

	@Override
	public void removerOfertante(Ofertante ofertante) {
		ofertanteDAO.removerOfertante(ofertante);

	}

	@Override
	public void removerOfertante(Long id) {
		ofertanteDAO.removerOfertante(id);

	}

}
