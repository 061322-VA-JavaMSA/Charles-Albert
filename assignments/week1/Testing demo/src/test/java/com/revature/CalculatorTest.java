package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revature.exceptions.Number13Exception;

public class CalculatorTest {

	private static Calculator sut;
	
	/*
	 * JUnit 5
	 * -@BeforeAll
	 * -@BeforeEach
	 * -@AfterAll
	 * -@AfterEach
	 * 
	 * -@Test
	 * -@Ignore
	 * - @order
	 */
	
	@BeforeAll
	public static void setup() {
		sut = new Calculator();
		
	}
	
	@AfterAll
	public static void tearDown() {
		System.out.println("Tear down behavior");
	}
	
	@BeforeEach
	public void before() {
		System.out.println("@Before each behavior");
	}
	
	@Test
	public void addOneAndTwo() {
		
		int expected = 3;
		int actual = sut.add(1, 2);
		assertEquals(expected, actual);
	}
	
	public void addEightandFive() {
		assertThrows(Number13Exception.class,()-> sut.add(5, 8));
	}
}
