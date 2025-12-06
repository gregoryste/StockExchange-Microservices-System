package br.edu.unisinos.acoes.service.model.dto;

import java.math.BigDecimal;

public record CreateAcaoRequest(String nome, String codigo, Integer qtdeAcoes, BigDecimal precoUnitario) {

}
