package com.catering.catering_hub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.catering.catering_hub.controllers", "com.catering.catering_hub.services"})
@EntityScan("com.catering.catering_hub.models")
@EnableJpaRepositories("com.catering.catering_hub.repository")
public class CateringHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(CateringHubApplication.class, args);
	}

}
