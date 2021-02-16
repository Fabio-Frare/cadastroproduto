package br.com.cadastroproduto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.exception.ProdutoNotFoundException;
import br.com.cadastroproduto.repository.ProdutoRepository;

@Service
public class BuscarProdutoPorIdServiceImpl {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto buscarPorId(Long id) throws ProdutoNotFoundException {
		Optional<Produto> optionalProduto = getOptional(id);
		Produto produto = null;
		if (!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException("Produto nao encontrado através do ID: " + id);
		} else {
			produto = optionalProduto.get();
		}
		return produto;

	}

	private Optional<Produto> getOptional(Long id) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		return optionalProduto;
	}

	public void deletarPorId(Long id) throws ProdutoNotFoundException {
		Optional<Produto> optionalProduto = getOptional(id);
		if (!optionalProduto.isPresent()) {
			throw new ProdutoNotFoundException("Produto nao encontrado através do ID: " + id);
		} else {
			produtoRepository.delete(optionalProduto.get());
		}

	}

}
