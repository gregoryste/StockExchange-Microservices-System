package br.edu.unisinos.cotacoes.service.service.integration.rest;

import java.math.BigDecimal;

public record EconomiaApiResponse(DollarToReais USDBRL) {
	
	public record DollarToReais (
			BigDecimal bid) {
		}
}
