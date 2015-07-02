package Dao;

import Model.Cliente;
import Model.Sessao;

public interface ClienteDAO extends GenericaDAO<Cliente>{
	public Cliente cadastrarCliente(Cliente cliente);
	public void removerCliente(Cliente cliente); 
	public void removerCliente(Long id);
	Sessao validarCliente(String email, String senha);
	
}
