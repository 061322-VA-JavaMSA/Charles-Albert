package com.revature;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Hello from Eclipse! ");
	
		boolean bool = true; // 1 bit
		byte myByte = 127; // 8 bits(-128 to 127)
 //		myByte = 128;
		short myShort = 128; // 16 bits or 2 bytes
		char myChar = 'a'; // 16 bits of memory
		
		int standardDataTypeForWholeNumber = 12345; // 32 bits
		float lessPreciseDouble = 92.3f; //32 bits
		
		double stanardDecimal = 28.45; // 64 bits
		long bigNumber = 165654654; // 64 bits
		
		String s = "Hello";
		String s2 = new String("World");
		
		
		Integer intWrap = standardDataTypeForWholeNumber;
		
	 
		System.out.println("Max.Integer: " + Integer.MAX_VALUE +"min vale for int" + Integer.MIN_VALUE);
		
		int[] numbers;
		
		numbers = new int[5];
		
		numbers[0] = 2;
		numbers[3] = 4;
		
		System.out.println(numbers[0]);
		
		for(int in : numbers) {
			
			System.out.println(in);
		}
		
		String k = "kevin";
		char[] chars = k.toCharArray();
		
		for(char c : chars) {
			System.out.println(c);
		}
	}
	
}
