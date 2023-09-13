package com.exam.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SecurityExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityExApplication.class, args);
	}

}
