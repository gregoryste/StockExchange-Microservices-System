package br.edu.unisinos.acoes.service.model;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Acao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String codigo;
	@Column(nullable = false)
	private Integer qtdeAcoes;
	@Column(nullable = false, scale = 4)
	private BigDecimal precoUnitario;
	
	public Acao() {
	}
	public Acao(String nome, String codigo, Integer qtdeAcoes, BigDecimal precoUnitario) {
		this.nome = nome;
		this.codigo = codigo;
		this.qtdeAcoes = qtdeAcoes;
		this.precoUnitario = precoUnitario;
	}
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getQtdeAcoes() {
		return qtdeAcoes;
	}
	public void setQtdeAcoes(Integer qtdeAcoes) {
		this.qtdeAcoes = qtdeAcoes;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	

}
