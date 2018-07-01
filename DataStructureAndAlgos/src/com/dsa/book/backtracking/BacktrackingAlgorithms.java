package com.dsa.book.backtracking;

import java.util.Arrays;

public class BacktrackingAlgorithms {

	static int[] binaryString;

	public BacktrackingAlgorithms(int size) {
		binaryString = new int[size];
	}

	public BacktrackingAlgorithms() {
	}

	public static void main(String[] args) {
		new BacktrackingAlgorithms(3);
		generateAllBinaryStrings(3);
	}

	private static void generateAllBinaryStrings(int n) {
		if (n < 1) {
			System.out.println(Arrays.toString(binaryString));
		} else {
			binaryString[n - 1] = 0;
			generateAllBinaryStrings(n - 1);
			binaryString[n - 1] = 1;
			generateAllBinaryStrings(n - 1);
		}
	}
}
