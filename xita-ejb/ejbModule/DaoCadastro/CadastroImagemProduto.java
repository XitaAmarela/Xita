package DaoCadastro;

import java.util.List;

import Model.ImagemProduto;
import Model.ProdutoOferta;

public interface CadastroImagemProduto {
	public ImagemProduto cadastrarImagemProduto(ImagemProduto imagem);
	public List<ImagemProduto> listarImagens();
	public ImagemProduto buscarImagemPorProduto(ProdutoOferta produtoOferta);
}
