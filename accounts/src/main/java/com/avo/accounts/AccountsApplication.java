package com.avo.accounts;

import com.avo.accounts.dto.AccountsContactInfoDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts Microservice REST API Documentation",
                description = "Avo Bank Accounts Microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Avo Bank Accounts - Development Team",
                        email = "acc.dev@avo.com",
                        url = "http://localhost:8080/swagger-ui/index.html#/"
                ),
                license = @License(
                    name = "Apache 2.0",
                    url = "http://localhost:8080/swagger-ui/index.html#/"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "External Documentation for Avo Bank Microservices REST API Documentation",
                url = "http://localhost:8080/swagger-ui/index.html#/"
        )

)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
