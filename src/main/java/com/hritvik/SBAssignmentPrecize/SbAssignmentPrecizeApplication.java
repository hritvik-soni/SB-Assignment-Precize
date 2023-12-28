package com.hritvik.SBAssignmentPrecize;

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
				title = "SAT Result APIs",
				description = "This is an Assignment project for Precize ",
				version = "v1.0.1",
				contact = @Contact(
						name = "Hritvik Soni",
						email = "hritviksoni768@gmail.com",
						url="https://www.linkedin.com/in/hritvik-soni/"
				),
				license = @License(
						name="SAT Result APIs License",
						url = "https://github.com/hritvik-soni"
				)
		),
		externalDocs = @ExternalDocumentation(
				description="External Docs",
				url="https://github.com/hritvik-soni"
		)
)
public class SbAssignmentPrecizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbAssignmentPrecizeApplication.class, args);
	}

}
