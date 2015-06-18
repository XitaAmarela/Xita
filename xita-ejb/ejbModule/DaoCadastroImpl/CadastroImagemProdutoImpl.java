package DaoCadastroImpl;

import java.util.List;

import javax.ejb.EJB;

import Dao.ImagemProdutoDAO;
import DaoCadastro.CadastroImagemProduto;
import Model.ImagemProduto;
import Model.ProdutoOferta;

public class CadastroImagemProdutoImpl implements CadastroImagemProduto {
	@EJB
	private ImagemProdutoDAO imagemDAO;
	@Override
	public ImagemProduto cadastrarImagemProduto(ImagemProduto imagem) {		
		return imagemDAO.persist(imagem);
	}

	@Override
	public List<ImagemProduto> listarImagens() {
		return imagemDAO.listAll();
	}

	@Override
	public ImagemProduto buscarImagemPorProduto(ProdutoOferta produtoOferta) {
		// TODO BUSCAR IMAGEM POR PRODUTO!
		return null;
	}

}
