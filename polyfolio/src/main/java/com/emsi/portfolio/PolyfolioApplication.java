package com.emsi.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.emsi.portfolio.repository")
@EntityScan(basePackages = {"com.emsi.portfolio.model"})
public class PolyfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolyfolioApplication.class, args);
	}

}
