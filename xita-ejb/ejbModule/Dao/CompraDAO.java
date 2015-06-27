package Dao;

import java.util.List;

import Model.Cliente;
import Model.Compra;

public interface CompraDAO extends GenericaDAO<Compra> {

	public List<Compra> listarCompraPorCliente(Cliente cliente);
		
}
