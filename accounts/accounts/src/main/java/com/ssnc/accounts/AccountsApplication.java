package com.ssnc.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ssnc")
@EnableJpaRepositories("com.ssnc.repository")
@EntityScan("com.ssnc.entity")
public class AccountsApplication {

	/**
	 * This is the main application class for the Accounts service. It starts the Spring Boot application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
