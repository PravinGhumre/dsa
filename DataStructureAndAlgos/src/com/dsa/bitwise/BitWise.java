package com.dsa.bitwise;

@SuppressWarnings("unused")
public class BitWise {

	public static void main(String[] args) {
		// testMethod();
		// printNumberSystem();
		evaluateBitwiseOperators();

	}

	private static void printNumberSystem() {
		for (int i = -10; i <= 10; i++) {
			System.out.print(" Decimal " + i);
			System.out.print(" Binary " + Integer.toBinaryString(i));
			System.out.print(" Hexa " + Integer.toHexString(i));
			System.out.print(" Octal " + Integer.toOctalString(i));
			System.out.println(" ");
		}
	}

	private static void evaluateBitwiseOperators() {

		int a = 12; // 00001100 
		int b = 25; // 00011001

		System.out.println("12 & 12 = " + (a & a));
		System.out.println("12 | 12 = " + (a | a));
		System.out.println("12 ^ 12 = " + (a ^ a));
		System.out.println("~ 12 = " + (~a));

		System.out.println("12 & 25 = " + (a & b));
		System.out.println("12 | 25 = " + (a | b));
		System.out.println("12 ^ 25 = " + (a ^ b));

		System.out.println(" (12 << 1) =  " + (a << 1));
		System.out.println(" (25 << 1) =  " + (b << 1));

		System.out.println(" (12 >> 1) =  " + (a >> 1));
		System.out.println(" (12 >>> 1) =  " + (a >>> 1));
		System.out.println(" (25 >> 1) =  " + (b >> 1));
		System.out.println(" (25 >>> 1) =  " + (b >>> 1));

		System.out.println(" (3 >>> 1) =  " + (3 >>> 1));
		System.out.println(" (2 >>> 1) =  " + (2 >>> 1));

		for (int i = 0; i <= 10; i++) {
			System.out.println(" ( " + i + " >>> 1 ) = " + (i >>> 1));
		}

		System.out.println(" ~ 12 =  " + (~a));
		System.out.println(" ~ 25 =  " + (~b));

		System.out.println(" ~ 10 =  " + (~10));
		System.out.println(" ~-20 =  " + (~-20));

		System.out.println(" (12 >> 1) =  " + (a >> 1));

	}

	private static void testMethod() {
		int randInt = (int) (Math.random() * 10);
		if ((randInt & 1) == 1) {
			System.out.println("Odd number " + randInt);
		} else {
			System.out.println("Even number " + randInt);
		}
	}

}
