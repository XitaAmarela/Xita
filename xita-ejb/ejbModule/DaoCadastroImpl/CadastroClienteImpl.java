package DaoCadastroImpl;

import java.util.List;

import javax.ejb.EJB;

import Dao.ClienteDAO;
import DaoCadastro.CadastroCliente;
import Model.Cliente;

public class CadastroClienteImpl implements CadastroCliente {
	@EJB
	private ClienteDAO clienteDAO;

	@Override
	public Cliente cadastrarCliente(Cliente cliente) {
		if (cliente.getNome() == null || cliente.getCpf_cnpj() == null
				|| cliente.getEmail() == null || cliente.getEndereco() == null
				|| cliente.getDataNascimento() == null
				|| cliente.getSexo() == null || cliente.getSenha() == null) {
			return null;
		}
		
		return clienteDAO.persist(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return clienteDAO.listAll();
	}

	@Override
	public void removerCliente(Cliente cliente) {
		clienteDAO.removerCliente(cliente);

	}

	@Override
	public void removerCliente(Long id) {
		clienteDAO.removerCliente(id);
	}

	@Override
	public Cliente persist(Cliente t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
