package br.com.cadastroproduto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.exception.ProdutoNotFoundException;
import br.com.cadastroproduto.repository.ProdutoRepository;

@Service
public class BuscarProdutoPorCodBarrasServiceImpl {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto buscarPorCodBarras(Long codBarras) throws ProdutoNotFoundException {
		Produto optionalProduto = getOptional(codBarras);
		Produto produto = null;
		if (optionalProduto != null) {
			produto = optionalProduto;
		} else {
			throw new ProdutoNotFoundException("Produto nao encontrado através do codigo de barras: " + codBarras);
		}
		return produto;

	}

	private Produto getOptional(Long codBarras) {
		List<Produto> lista = produtoRepository.findAll();
		for (Produto produto : lista) {
			
			if (produto.getCodigoBarras().equals(codBarras) == true) {
				System.out.println("produto: " + produto.getCodigoBarras());
				return produto;
			}
		}
		return null;
	}

	public void deletarPorCodBarras(Long codBarras) throws ProdutoNotFoundException {
		Produto optionalProduto = getOptional(codBarras);
		if (optionalProduto.getCodigoBarras() == null) {
			throw new ProdutoNotFoundException("Produto nao encontrado através do codigo de barras: " + codBarras);
		} else {
			produtoRepository.delete(optionalProduto);
		}
	}

}
