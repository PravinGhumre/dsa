package com.dsa.book.recursion;

public class RecursionAlgorithms {

	public static void main(String[] args) {

		int fibonacciSeries = fibonacciSeries(9);
		System.out.println(" fibonacciSeries " + fibonacciSeries);

		int factorial = factorial(4);
		System.out.println(" factorial " + factorial);

		towerOfHonai(3, 'A', 'B', 'C');
	}

	private static void towerOfHonai(int n, char fromPeg, char toPeg, char auxPeg) {
		if (n == 1) {
			System.out.println(n + " From " + fromPeg + " ---> " + toPeg);
			return;
		}
		towerOfHonai(n - 1, fromPeg, auxPeg, toPeg);
		System.out.println(n + " From " + fromPeg + " ---> " + toPeg);
		towerOfHonai(n - 1, auxPeg, toPeg, fromPeg);

	}

	private static int factorial(int i) {
		if (i <= 1) {
			return 1;
		}
		return i * factorial(i - 1);
	}

	private static int fibonacciSeries(int i) {
		if (i <= 1) {
			return i;
		}
		return fibonacciSeries(i - 1) + fibonacciSeries(i - 2);
	}

}
