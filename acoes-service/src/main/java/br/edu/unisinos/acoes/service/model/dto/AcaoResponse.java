package br.edu.unisinos.acoes.service.model.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record AcaoResponse(
		UUID id,
		String nome, 
		String codigo, 
		Integer qtdeAcoes, 
		BigDecimal precoUnitario,
		BigDecimal valorTotalReal,
		BigDecimal valorTotalDolar
		) {

}
