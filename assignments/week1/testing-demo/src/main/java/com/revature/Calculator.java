package com.revature;

import com.revature.exceptions.Number13Exception;
import com.revature.exceptions.divideBy0Exception;

public class Calculator {
	/*
	 * - add(int a, int b)
	 * 		- if the result is 13
	 * 			- throw an exception
	 * 				- Number13Exception
	 * - subtract
	 * - multiply
	 * - sum of an array
	 * - divide
	 * - throw a custom exception if divided by 0
	 */
	
	public int add(int a, int b) {
		if(a + b == 13 ) {
			throw new Number13Exception();
		}
		return a + b;
	}
	
	public int subtract(int a, int b) {
		
		return a - b;
	} 
	
	
	public int sumOfAnArray() {
	    int arr[] = { 12, 3, 4, 15 };
		
	    int sum = 0; // initialize sum
        int i;
 
        // Iterate through all elements and add them to sum
        for (i = 0; i < arr.length; i++)
            sum += arr[i];
 
        return sum;
	}
		
    
	public int productOfOneAndTwo(int a, int b) {
    	return a * b;
    }
    
	public int divide(int a, int b) {
		if ( b == 0) {
			throw new divideBy0Exception();
		}
		return a / b;
	}
	
}
