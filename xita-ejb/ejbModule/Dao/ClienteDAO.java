package Dao;

import Model.Cliente;

public interface ClienteDAO extends GenericaDAO<Cliente>{

	public Cliente buscarPorId(Long id);
	public void removerCliente(Cliente cliente); 
	public void removerCliente(Long id);
	
}
