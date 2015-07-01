package Dao;

import Model.ImagemProduto;

public interface ImagemProdutoDAO extends GenericaDAO<ImagemProduto>{

	ImagemProduto cadastrarImagemProduto(ImagemProduto imagemProduto);
	public ImagemProduto buscarPorId(Long id);
}
