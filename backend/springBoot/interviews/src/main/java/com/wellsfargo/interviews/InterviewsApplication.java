package com.wellsfargo.interviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com.wellsfargo")
public class InterviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewsApplication.class, args);
	}

}
