package Dao;

import java.util.List;

import Model.Ofertante;
import Model.Sessao;


public interface OfertanteDAO extends GenericaDAO<Ofertante> {


	public List<Ofertante> buscarPorNome(String nome);
	public void removerOfertante(Ofertante ofertante); 
	public void removerOfertante(Long id);
	Ofertante cadastrarOfertante(Ofertante ofertante);
	Sessao validarOfertante(String email, String senha);
	
}
