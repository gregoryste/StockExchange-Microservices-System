package br.edu.unisinos.acoes.service.service.integration.rest;

import java.math.BigDecimal;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cotacoes-api")
public interface CotacoesClient {
	
	@GetMapping(value = "/cotacoes")
	public BigDecimal getBid();

}
