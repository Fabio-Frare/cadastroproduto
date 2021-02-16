package br.com.cadastroproduto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.exception.ProdutoNotFoundException;
import br.com.cadastroproduto.resource.model.ProdutoResource;
import br.com.cadastroproduto.service.BuscarProdutoPorCodBarrasServiceImpl;
import br.com.cadastroproduto.service.BuscarProdutoPorIdServiceImpl;
import br.com.cadastroproduto.service.BuscarProdutosServiceImpl;
import br.com.cadastroproduto.service.CadastroProdutoServiceImpl;

@RestController
@RequestMapping(value = "/cadastroproduto")
public class ProdutoController {

	@Autowired
	private BuscarProdutosServiceImpl serviceBuscar;

	@Autowired
	private CadastroProdutoServiceImpl serviceCadastro;

	@Autowired
	private BuscarProdutoPorIdServiceImpl serviceBuscarPorId;
	
	@Autowired
	private BuscarProdutoPorCodBarrasServiceImpl serviceBuscarPorCodBarras;

	@GetMapping(path = "/produtos")
	public List<Produto> buscarProdutos() {
		return serviceBuscar.buscarTodosOsProdutos();
	}

	@GetMapping(path = "/produto/id/{id}")
	public Produto buscarProdutoPorId(@PathVariable(name = "id", required = true) Long id)
			throws ProdutoNotFoundException {
		return serviceBuscarPorId.buscarPorId(id);
	}
	
	@GetMapping(path = "/produto/codigoBarras/{codigoBarras}")
	public Produto buscarProdutoPorCodBarras(@PathVariable(name = "codigoBarras", required = true) Long codigoBarras)
			throws ProdutoNotFoundException {
		return serviceBuscarPorCodBarras.buscarPorCodBarras(codigoBarras);
	}
	
	@DeleteMapping(path = "/produto/codigoBarras/delete/{codigoBarras}")
	public void deleteProdutoCodBarras(@PathVariable(name = "codigoBarras", required = true) Long codigoBarras) throws ProdutoNotFoundException {
		serviceBuscarPorCodBarras.deletarPorCodBarras(codigoBarras);
	}

	@PostMapping(path = "/produto/save")
	public void salvarProduto(@RequestBody ProdutoResource produto) {
		serviceCadastro.cadastro(produto);
	}

	@DeleteMapping(path = "/produto/delete/{id}")
	public void deleteProduto(@PathVariable(name = "id", required = true) Long id) throws ProdutoNotFoundException {
		serviceBuscarPorId.deletarPorId(id);
	}
	

}
