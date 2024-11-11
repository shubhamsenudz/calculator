package com.calculator.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	 public static int add(String numbers) {
	        if (numbers.isEmpty()) {
	            return 0;
	        }
	        return 0;  //future changes
	    }

}
