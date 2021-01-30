package br.com.cadastroproduto.resource.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProdutoResource implements Serializable {

	private static final long serialVersionUID = 6030862910379069667L;

	@JsonProperty("descricao")
	private String descricao;

	@JsonProperty("codigo_barras")
	private String codBarras;

	@JsonProperty("quantidade")
	private String quantidade;

	@JsonProperty("unidadeMedida")
	private String unidadeMedida;

	@JsonProperty("valor")
	private String valor;

	@JsonProperty("icms")
	private String icms;

	@JsonProperty("ipi")
	private String ipi;

	public String getDescricao() {
		return descricao;
	}

	public ProdutoResource(String descricao, String codBarras, String quantidade, String unidadeMedida, String valor,
			String icms, String ipi) {
		super();
		this.descricao = descricao;
		this.codBarras = codBarras;
		this.quantidade = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.valor = valor;
		this.icms = icms;
		this.ipi = ipi;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getIcms() {
		return icms;
	}

	public void setIcms(String icms) {
		this.icms = icms;
	}

	public String getIpi() {
		return ipi;
	}

	public void setIpi(String ipi) {
		this.ipi = ipi;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", codBarras=" + codBarras + ", quantidade=" + quantidade
				+ ", unidadeMedida=" + unidadeMedida + ", valor=" + valor + ", icms=" + icms + ", ipi=" + ipi + "]";
	}

}