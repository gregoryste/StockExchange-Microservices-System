package br.edu.unisinos.cotacoes.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CotacoesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotacoesServiceApplication.class, args);
	}

}
