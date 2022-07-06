package com.generation.lojagames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produto")
public class ProdutoModel {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String nomeJogo;
	
	@NotNull
	@Size(min = 4, max = 4)
	private int anoJogo;
	
	@NotNull
	@Column (columnDefinition = "decimal(7,2)")
	private double valorJogo;
	
	@NotNull
	private int quantidadeEstoque;
	
	private String modeloVideogame;
	
	@ManyToOne
	@JsonIgnoreProperties("produto")
	private CategoriaModel categoria;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNomeJogo() {
		return nomeJogo;
	}

	public void setNomeJogo(String nomeJogo) {
		this.nomeJogo = nomeJogo;
	}

	public int getAnoJogo() {
		return anoJogo;
	}

	public void setAnoJogo(int anoJogo) {
		this.anoJogo = anoJogo;
	}

	public double getValorJogo() {
		return valorJogo;
	}

	public void setValorJogo(double valorJogo) {
		this.valorJogo = valorJogo;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public String getModeloVideogame() {
		return modeloVideogame;
	}

	public void setModeloVideogame(String modeloVideogame) {
		this.modeloVideogame = modeloVideogame;
	}


}
