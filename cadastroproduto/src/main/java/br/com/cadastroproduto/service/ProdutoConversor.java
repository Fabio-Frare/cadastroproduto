package br.com.cadastroproduto.service;

import org.springframework.stereotype.Component;

import br.com.cadastroproduto.datasource.model.Produto;
import br.com.cadastroproduto.exception.ProdutoResourceException;
import br.com.cadastroproduto.resource.model.ProdutoResource;

@Component
public class ProdutoConversor {

	public Produto conversor(ProdutoResource produtoResource) throws ProdutoResourceException {
		
		try {

			Produto produto = new Produto.ProdutoBuilder().criarProduto();// CriarProduto é um método do padrão Builder.
			
			Long codBarras       = checkCodBarras(produtoResource.getCodBarras());
			String descricao     = produtoResource.getDescricao();
			int quantidade       = checkQuantidade(produtoResource.getQuantidade());
			String unidadeMedida = produtoResource.getUnidadeMedida();
			float valor          = checkValor(produtoResource.getValor());
			int icms             = checkIcms(produtoResource.getIcms());
			int ipi              = checkIpi(produtoResource.getIpi());

			produto.setCodigoBarras(codBarras);
			produto.setDescricao(descricao);
			produto.setQuantidade(quantidade);
			produto.setUnidadeMedida(unidadeMedida);
			produto.setValor(valor);
			produto.setIcms(icms);
			produto.setIpi(ipi);

			return produto;

		} catch (Exception e) {
	
			throw new ProdutoResourceException(
					"Falha ao converter o resource para entidade, resouce: " + produtoResource);
		}

	}

	private Long checkCodBarras(String codBarras) {
		return Long.parseLong(codBarras);
	}

	private int checkQuantidade(String quantidade) {
		return Integer.parseInt(quantidade);
	}

	private float checkValor(String valor) {
		return Float.parseFloat(valor);
	}

	private int checkIcms(String icms) {
		return Integer.parseInt(icms);
	}

	private int checkIpi(String ipi) {
		return Integer.parseInt(ipi);
	}

}
