package com.shubham.expense_tracker_app;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Expense Tracker Rest API",
				description = "Expense Tracker Rest API Documentation",
				version = "V1.0",
				contact = @Contact(
						name = "Shubham Patil",
						email = "patilshubham6803@gmail.com",
						url = "http://www.patil.com"
				),

				license = @License(
						name = "Apache 2.0",
						url = "http://www.patil.com/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "These documents are used for developers",
				url = "http://www.patil.com/external"
		)
)
@SpringBootApplication
public class ExpenseTrackerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerAppApplication.class, args);
	}

}
