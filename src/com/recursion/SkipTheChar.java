package com.recursion;

public class SkipTheChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(skipTheChar("abbhsyajda", ""));
	}

	public static String skipTheChar(String s, String res) {
		if (s.length() == 0) {
			return res;
		}

		if (s.charAt(0) != 'a') {
			res += s.charAt(0);
		}

		return skipTheChar(s.substring(1), res);

	}

}
