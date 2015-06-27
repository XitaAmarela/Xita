package DaoCadastro;

import java.util.List;

import Model.Cliente;

public interface CadastroCliente {
	public Cliente cadastrarCliente(Cliente cliente);
	public List<Cliente> listarClientes();
	public void removerCliente(Cliente cliente);
	public void removerCliente(Long id);
}
