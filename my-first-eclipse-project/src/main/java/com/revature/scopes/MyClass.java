package com.revature.scopes;

public class MyClass {

	public String reverseString(String stringToBeReversed) {
		
		String reversed = "";
		
		char[]letters = stringToBeReversed.toCharArray();
		
		for (int i = letters.length-1; i >= 0; i--) {
			reversed = reversed + letters[i];
		}
		
		return	reversed;
	}
}
