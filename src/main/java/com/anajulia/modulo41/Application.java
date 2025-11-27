package com.anajulia.modulo41;

import com.anajulia.modulo41.entidades.Pessoa;
import com.anajulia.modulo41.kafka.PessoaAtualizadaProdutor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application implements org.springframework.boot.CommandLineRunner {

	private final PessoaAtualizadaProdutor produtor;

	public Application(PessoaAtualizadaProdutor produtor) {
		this.produtor = produtor;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Enviando mensagem para o Kafka...");
		produtor.enviar(new Pessoa(
				"Ana Julia",
				LocalDateTime.now().toLocalDate()
		));
		System.out.println("Mensagem enviada com sucesso!");
	}
}
