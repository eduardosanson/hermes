package com.br.sanson;

import com.br.sanson.repository.MessageConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HermesApplication  {

	@Autowired
	private MessageConfigRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(HermesApplication.class, args);
	}

}
