package br.com.cadastroproduto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.repository.ProdutoRepository;

@Service
public class BuscarProdutosServiceImpl {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> buscarTodosOsProdutos() {
		List<Produto> listProduto = produtoRepository.findAll();
		return listProduto;
	}
	
}
