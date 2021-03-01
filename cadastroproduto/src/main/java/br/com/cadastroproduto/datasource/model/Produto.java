package br.com.cadastroproduto.datasource.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 3862024889868951158L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String descricao;
	private Long codigoBarras;
	private int quantidade;
	private String unidadeMedida;
	private float valor;
	private int icms;
	private int ipi;
	

	private Produto() {

	}

	private Produto (String descricao, Long codigoBarras, int quantidade, String unidadeMedida, float valor,
			int icms, int ipi) {
		super();
		this.descricao     = descricao;
		this.codigoBarras  = codigoBarras;
		this.quantidade    = quantidade;
		this.unidadeMedida = unidadeMedida;
		this.valor         = valor;
		this.icms          = icms;
		this.ipi           = ipi;
	}

	// Início da implementação do padrão Builder 
	public static class ProdutoBuilder {
		private String descricao;
		private Long codigoBarras;
		private int quantidade;
		private String unidadeMedida;
		private float valor;
		private int icms;
		private int ipi;

		public ProdutoBuilder() {

		}

		public ProdutoBuilder( String descricao, Long codigoBarras, int quantidade, String unidadeMedida,
				float valor, int icms, int ipi) {
			super();
			this.descricao     = descricao;
			this.codigoBarras  = codigoBarras;
			this.quantidade    = quantidade;
			this.unidadeMedida = unidadeMedida;
			this.valor         = valor;
			this.icms          = icms;
			this.ipi           = ipi;
		}

		public ProdutoBuilder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}

		public ProdutoBuilder codigoBarras(Long codigoBarras) {
			this.codigoBarras = codigoBarras;
			return this;
		}

		public ProdutoBuilder quantidade(int quantidade) {
			this.quantidade = quantidade;
			return this;
		}

		public ProdutoBuilder unidadeMedida(String unidadeMedida) {
			this.unidadeMedida = unidadeMedida;
			return this;
		}

		public ProdutoBuilder valor(float valor) {
			this.valor = valor;
			return this;
		}

		public ProdutoBuilder icms(int icms) {
			this.icms = icms;
			return this;
		}

		public ProdutoBuilder ipi(int ipi) {
			this.ipi = ipi;
			return this;
		}

		public Produto criarProduto() {
			return new Produto( descricao, codigoBarras, quantidade, unidadeMedida, valor, icms, ipi);
		}

	} // Final da implementação do padrão Builder

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(Long codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(String unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public int getIcms() {
		return icms;
	}

	public void setIcms(int icms) {
		this.icms = icms;
	}

	public int getIpi() {
		return ipi;
	}

	public void setIpi(int ipi) {
		this.ipi = ipi;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", codigoBarras=" + codigoBarras + ", quantidade="
				+ quantidade + ", unidadeMedida=" + unidadeMedida + ", valor=" + valor + ", icms=" + icms + ", ipi="
				+ ipi + "]";
	}

	
}
