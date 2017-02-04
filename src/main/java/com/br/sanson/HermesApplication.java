package com.br.sanson;

import com.br.sanson.aplication.config.MessageConfig;
import com.br.sanson.aplication.repository.MessagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HermesApplication implements CommandLineRunner {

	@Autowired
	private MessagingRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HermesApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		String message = "mensagem de teste";
		String eventType = "billingEvent";
		String tenant = "teste";
		MessageConfig config = new MessageConfig(message,eventType,tenant);

		repository.save(config);


	}
}
