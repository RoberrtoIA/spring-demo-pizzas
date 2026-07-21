package com.pizza.sesamo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SesamoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SesamoApplication.class, args);
	}

}
