package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.divideBy0Exception;

public class CalculatorTest {
	
	
	private static Calculator sut;
	 
		 /*
		 * JUnit 5
		 * 	- @BeforeAll
		 *  - @BeforeEach
		 *  - @AfterAll
		 *  - @AfterEach
		 *  
		 *  - @Test
		 *  - @Ignore
		 *  - @Order
		 */
	
		// Used to set up the test
		@BeforeAll
		public static void setUp() {
			sut = new Calculator();
		}
		
		@AfterAll
		public static void tearDown() {
			System.out.println("Tear down behavior.");
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
		
		@Test 
		public void substactOneAndTwo() {
			int expected = 6;
			int actual = sut.subtract(9, 3);
		    
			assertEquals(expected, actual);
		}
		
		@Test
		public void addEightAndFive() {
			assertThrows(Number13Exception.class, () -> sut.add(8, 5));
		}
		
		@Test
		public void addZeroAndThirteen() {
			assertThrows(Number13Exception.class, () -> sut.add(0, 13));
		}
		
		@Test
		public void addArraySum() {
			
			int expected = 34;
			int actual = sut.sumOfAnArray();
			
			assertEquals(expected, actual);
			
		}
		
		@Test
		public void multipyOneAndTwo() {
			int expected = 6;
			int actual = sut.productOfOneAndTwo(6, 1);
			
			assertEquals(expected, actual);
			
		}
		
		@Test
		public void divideByZero() {
			assertThrows(divideBy0Exception.class, ()-> sut.divide(5, 0));
		}
		
}
