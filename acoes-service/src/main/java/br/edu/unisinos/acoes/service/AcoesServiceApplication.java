package br.edu.unisinos.acoes.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AcoesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcoesServiceApplication.class, args);
	}

}
