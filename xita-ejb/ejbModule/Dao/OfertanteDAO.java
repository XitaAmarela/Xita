package Dao;

import java.util.List;

import Model.Ofertante;


public interface OfertanteDAO extends GenericaDAO<Ofertante> {

	public Ofertante buscarPorId(Long id);
	public List<Ofertante> buscarPorNome(String nome);
	public void removerOfertante(Ofertante ofertante); 
	public void removerOfertante(Long id);
	
}
