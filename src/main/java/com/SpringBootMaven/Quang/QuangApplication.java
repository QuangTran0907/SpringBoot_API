package com.SpringBootMaven.Quang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootApplication(exclude = { ThymeleafAutoConfiguration.class })
public class QuangApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuangApplication.class, args);
	}

}
