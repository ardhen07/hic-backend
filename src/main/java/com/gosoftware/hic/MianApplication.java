package com.gosoftware.hic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;



@SpringBootApplication
@EnableJpaAuditing
public class MianApplication {
	public static void main(String[] args) {
		SpringApplication.run(MianApplication.class, args);
    }
}
