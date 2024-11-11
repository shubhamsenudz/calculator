package com.calculator.app;

import java.util.ArrayList;
import java.util.List;

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
	    List<String> negativeNumbers = new ArrayList<>();
	    if (numbers.startsWith("//")) {
	        String delimiter = numbers.substring(2, numbers.indexOf("\n"));
	        numbers = numbers.substring(numbers.indexOf("\n") + 1);
	        numbers = numbers.replace(delimiter, ",");
	    }
	    numbers = numbers.replace("\n", ",");
	    String[] numArray = numbers.split(",");
	    int sum = 0;
	    for (String num : numArray) {
	        int parsedNum = Integer.parseInt(num);
	        if (parsedNum < 0) {
	            negativeNumbers.add(num);
	        }
	        sum += parsedNum;
	    }
	    if (!negativeNumbers.isEmpty()) {
	        throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negativeNumbers));
	    }
	    return sum;
	}

}
