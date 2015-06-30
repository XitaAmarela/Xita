package DaoCadastro;

import java.util.List;

import Dao.GenericaDAO;
import Model.Cliente;
import Model.ProdutoOferta;

public interface CadastroCliente extends GenericaDAO<Cliente>{
	public Cliente cadastrarCliente(Cliente cliente);
	public List<Cliente> listarClientes();
	public void removerCliente(Cliente cliente);
	public void removerCliente(Long id);
}
