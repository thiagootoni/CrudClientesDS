package com.thiago.clientes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudClientesDsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CrudClientesDsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O pai tá on!");
	}

}
