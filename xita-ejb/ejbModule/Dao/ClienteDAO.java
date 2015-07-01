package Dao;

import Model.Cliente;

public interface ClienteDAO extends GenericaDAO<Cliente>{
	public Cliente cadastrarCliente(Cliente cliente);
	public void removerCliente(Cliente cliente); 
	public void removerCliente(Long id);
	public Long validarCliente(Cliente cliente);
	
}
