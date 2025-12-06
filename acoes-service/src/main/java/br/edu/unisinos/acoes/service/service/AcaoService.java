package br.edu.unisinos.acoes.service.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.edu.unisinos.acoes.service.model.Acao;
import br.edu.unisinos.acoes.service.model.dto.AcaoResponse;
import br.edu.unisinos.acoes.service.model.dto.CreateAcaoRequest;
import br.edu.unisinos.acoes.service.repository.AcaoRepository;
import br.edu.unisinos.acoes.service.service.integration.rest.CotacoesClient;

@Service
public class AcaoService {
	
	private final CotacoesClient cotacoesClient;
	private final AcaoRepository acaoRepository;

	public AcaoService(CotacoesClient cotacoesClient, AcaoRepository acaoRepository) {
		this.cotacoesClient = cotacoesClient;
		this.acaoRepository = acaoRepository;
	}
	
	public Acao createAcao(CreateAcaoRequest request) {
		Acao acao = new Acao(request.nome(), request.codigo(), request.qtdeAcoes(), request.precoUnitario());
		return acaoRepository.save(acao);
		
	}
	
	public List<AcaoResponse> getAcao(final String code) {
		final BigDecimal bid = getBid();
		
		if (Objects.isNull(code)) {
			return acaoRepository.findAll()
				.stream()
				.map(acao -> createResponse(acao, bid))
				.toList();
		}

		return acaoRepository.findByCodigo(code)
				.stream()
				.map(acao -> createResponse(acao, bid))
				.toList();
	}
	
	public List<Acao> getAcoes(){
		return acaoRepository.findAll();
	}
	
	public void remove(UUID id) {
		acaoRepository.deleteById(id);
	}
	
	private BigDecimal getBid() {
		return cotacoesClient.getBid();
		
	}
	
	private AcaoResponse createResponse(Acao acao,  BigDecimal bid) {

        final BigDecimal valorTotalReal = acao.getPrecoUnitario().multiply(BigDecimal.valueOf(acao.getQtdeAcoes()));

        final BigDecimal valorTotalDolar = valorTotalReal.divide(bid, 4, RoundingMode.HALF_UP);
		
		return new AcaoResponse(acao.getId(), 
				acao.getNome(), 
				acao.getCodigo(), 
				acao.getQtdeAcoes(), 
				acao.getPrecoUnitario(), 
				valorTotalReal, 
				valorTotalDolar);
	}
	
}
