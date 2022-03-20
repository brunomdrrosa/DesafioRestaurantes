package com.dbserver.restaurantes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
@OpenAPIDefinition(info = @Info(title = "Restaurant API", version = "1.0.0", description = "API created for DBServer employees to be able to choose a restaurant to have lunch through a voting system."))
public class RestaurantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestaurantsApplication.class, args);
	}

}
