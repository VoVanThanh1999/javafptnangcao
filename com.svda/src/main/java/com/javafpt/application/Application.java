package com.javafpt.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.javafpt.controller")
@ComponentScan("com.javafpt.dto")
@EntityScan("com.javafpt.entities")
@EnableJpaRepositories("com.javafpt.repository")
@ComponentScan("com.javafpt.service")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
