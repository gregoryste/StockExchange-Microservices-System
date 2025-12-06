package br.edu.unisinos.cotacoes.service.controller;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unisinos.cotacoes.service.service.CotacoesService;

@RestController
@RequestMapping("/cotacoes")
public class CotacoesController {
	
	private final CotacoesService cotacoesService;
	
	public CotacoesController(CotacoesService cotacoesService) {
		this.cotacoesService = cotacoesService;
	}

	@GetMapping
	public BigDecimal getCotacoes() {
		return cotacoesService.getDollarBid();
	}

}
