package br.edu.unisinos.cotacoes.service.service.integration.rest;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "economia-api")
public interface EconomiaClient {
	
	@GetMapping(value = "/json/last/USD-BRL")
	public EconomiaApiResponse getDollarCotation();

}
