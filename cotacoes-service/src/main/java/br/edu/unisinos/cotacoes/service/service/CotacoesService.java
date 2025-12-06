package br.edu.unisinos.cotacoes.service.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import br.edu.unisinos.cotacoes.service.service.integration.rest.EconomiaClient;

@Service
public class CotacoesService {
	
	private final EconomiaClient economiaClient;

	public CotacoesService(EconomiaClient economiaClient) {
		this.economiaClient = economiaClient;
	}
	
	public BigDecimal getDollarBid() {
		return economiaClient.getDollarCotation().USDBRL().bid();
	}

}
