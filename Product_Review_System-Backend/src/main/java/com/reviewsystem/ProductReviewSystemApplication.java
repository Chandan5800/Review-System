package com.reviewsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProductReviewSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductReviewSystemApplication.class, args);
		System.out.println("Your application is started...");
	}	
}
