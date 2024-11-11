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
	    
	    String[] numArray = numbers.split(",");
	    int sum = 0;
	    for (String num : numArray) {
	        sum += Integer.parseInt(num);
	    }
	    return sum;
	}

}
