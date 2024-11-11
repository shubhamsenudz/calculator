package com.calculator.app;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	        String delimiter = ",";
	        if (numbers.startsWith("//")) {
	            numbers = extractCustomDelimiter(numbers);
	            delimiter = numbers.substring(0, 1);
	        }
	        numbers = numbers.replace("\n", delimiter);
	        String[] numArray = numbers.split(delimiter);
	        return parseAndSum(numArray);
	    }

	    private static String extractCustomDelimiter(String numbers) {
	        Matcher matcher = Pattern.compile("//(.*?)\n").matcher(numbers);
	        if (matcher.find()) {
	            String delimiter = matcher.group(1);
	            numbers = numbers.substring(matcher.end());
	            return delimiter + numbers;
	        }
	        return numbers;
	    }

	    private static int parseAndSum(String[] numArray) {
	        int sum = 0;
	        List<String> negativeNumbers = new ArrayList<>();
	        for (String num : numArray) {
	            try {
	                int parsedNum = Integer.parseInt(num);
	                if (parsedNum < 0) {
	                    negativeNumbers.add(num);
	                }
	                sum += parsedNum;
	            } catch (NumberFormatException e) {
	                throw new IllegalArgumentException("Invalid number format: " + num);
	            }
	        }
	        if (!negativeNumbers.isEmpty()) {
	            throw new IllegalArgumentException("Negative numbers not allowed: " + String.join(",", negativeNumbers));
	        }
	        return sum;
	    }

}
