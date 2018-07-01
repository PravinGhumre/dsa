package com.dsa;

public class ReverseStringRecursviely {

	public static void main(String[] args) {
		String name = "PRAVIN";
		String reversedName = ReverseStringRecursviely.reverseString(name);
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
