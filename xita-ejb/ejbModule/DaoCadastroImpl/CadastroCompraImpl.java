package DaoCadastroImpl;

import javax.ejb.EJB;

import Dao.CompraDAO;
import DaoCadastro.CadastroCompra;
import Model.Compra;

public class CadastroCompraImpl implements CadastroCompra{
	@EJB
	private CompraDAO compraDAO;
	@Override
	public Compra cadastrarCompra(Compra compra) {
		return compraDAO.persist(compra);
	}

}
