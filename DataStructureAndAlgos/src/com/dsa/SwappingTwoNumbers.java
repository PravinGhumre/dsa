package com.dsa;

import java.util.Scanner;

public class SwappingTwoNumbers {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Two Numbers fo Swapping : ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(" a " + a);
		System.out.println(" b " + b);
		SwappingTwoNumbers.swapTwoNumbers(a, b);
	}

	private static void swapTwoNumbers(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(" After Swapping a " + a);
		System.out.println(" After Swapping b " + b);
	}
}
