package com.richardvynz.StockManager_Application;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title ="STOCK MANAGING APPLICATION",
				description ="Backend application for a stock management.",
				version="v1.0",
				contact= @Contact(
						name ="Richard Vincent",
						email = "richardvynz@gmail.com"
				),
				license = @License(
						name = "Stock Management, Version 2.0",
						url = "https://github.com/richardvynz/StockManagement_app.git"

				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Simple Stock Management application using spring boot",
				url = "https://github.com/richardvynz/StockManagement_app.git"
		)
)
public class StockManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockManagerApplication.class, args);
	}


}
