package com.calculator.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppApplicationTests {

	@Test
	void contextLoads() {
	}
	 @Test
	    public void testEmptyString() {
	        assertEquals(0, AppApplication.add(""));
	    }
	 @Test
	 public void testSingleNumber() {
	     assertEquals(1, AppApplication.add("1"));
	 }
	

}
