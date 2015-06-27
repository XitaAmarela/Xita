package Dao;

import Model.Cliente;

public interface ClienteDAO extends GenericaDAO<Cliente>{

	public void removerCliente(Cliente cliente); 
	public void removerCliente(Long id);
	
}
