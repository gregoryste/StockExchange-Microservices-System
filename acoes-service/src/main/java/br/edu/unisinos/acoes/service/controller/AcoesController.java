package br.edu.unisinos.acoes.service.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unisinos.acoes.service.model.Acao;
import br.edu.unisinos.acoes.service.model.dto.AcaoResponse;
import br.edu.unisinos.acoes.service.model.dto.CreateAcaoRequest;
import br.edu.unisinos.acoes.service.service.AcaoService;

@RestController
@RequestMapping("/acoes")
public class AcoesController {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	private final AcaoService acaoService;
	
	public AcoesController(AcaoService acaoService) {
		this.acaoService = acaoService;
	}
	
	@PostMapping
	public Acao create(@RequestBody CreateAcaoRequest request) {
		log.info("Received post request at /acoes with payload {}", request);
		return acaoService.createAcao(request);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable UUID id) {
		log.info("Received delete request at /acoes");
		acaoService.remove(id);
	}
	
	@GetMapping
	public List<AcaoResponse> get(@RequestParam(required = false) String codigo) {
		log.info("Received get request at /acoes with codigo {}", codigo);
		return acaoService.getAcao(codigo);
	}
	
}
