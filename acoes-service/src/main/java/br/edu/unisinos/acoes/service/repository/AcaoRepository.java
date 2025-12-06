package br.edu.unisinos.acoes.service.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unisinos.acoes.service.model.Acao;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, UUID>{
	
	List<Acao> findByCodigo(final String code);
}
