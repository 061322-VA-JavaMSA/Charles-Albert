package com.revature.scopes;

public class Driver {

	public static void main(String[] args) {
		MyClass mc = new MyClass();
			
		System.out.println(mc.reverseString(" Charles"));	
		System.out.println(mc.reverseString(" Chasson"));
	}

}
