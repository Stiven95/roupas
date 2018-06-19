package br.com.fiap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
@EnableJpaRepositories
public class RoupasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoupasApplication.class, args);
	}
}