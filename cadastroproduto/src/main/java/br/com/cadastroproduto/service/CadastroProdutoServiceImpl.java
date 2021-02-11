package br.com.cadastroproduto.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.exception.ProdutoResourceException;
import br.com.cadastroproduto.repository.ProdutoRepository;
import br.com.cadastroproduto.resource.model.ProdutoResource;

@Service
public class CadastroProdutoServiceImpl {

	private static final Logger LOG = Logger.getLogger(CadastroProdutoServiceImpl.class);

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ProdutoConversor service;

	public void cadastro(ProdutoResource produtoResource) {

		try {

			Produto produto = service.conversor(produtoResource);
			produtoRepository.saveAndFlush(produto);
			

		} catch (ProdutoResourceException e) {
			LOG.error("Erro ao salvar o produto: " + e.getMessage(), e);
		}

	}

}
