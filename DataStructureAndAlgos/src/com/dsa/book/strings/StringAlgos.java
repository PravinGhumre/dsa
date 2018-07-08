package com.dsa.book.strings;

public class StringAlgos {

	public static void main(String[] args) {

		// Reversing String
		String name = "PRAVIN";
		String reversedName = reverseString(name);
		System.out.println(" Name " + name);
		System.out.println(" Reversed Name " + reversedName);
	}

	private static String reverseString(String name) {
		if (name.length() < 2) {
			System.out.println(" returning " + name);
			return name;
		}
		return reverseString(name.substring(1)) + name.charAt(0);
	}

}
