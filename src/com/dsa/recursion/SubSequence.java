package com.dsa.recursion;

public class SubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		subSequence("", "abc");
	}
	
	public static void subSequence(String processed, String unProcessed) {
		if(unProcessed.isEmpty()) {
			System.out.println(processed);
			return;
		}
		char c=unProcessed.charAt(0);
		
		subSequence(processed+c, unProcessed.substring(1));
		subSequence(processed, unProcessed.substring(1));
		
	}

}
