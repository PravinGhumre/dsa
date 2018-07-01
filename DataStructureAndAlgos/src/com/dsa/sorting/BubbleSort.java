package com.dsa.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] unsortedArrs = { 8, 9, 4, 6, 2, 7, 5, 3, 1 };
		int[] sortedArray = bubbleSort(unsortedArrs);
		System.out.println(Arrays.toString(sortedArray));

		bubbleSortRecursive(unsortedArrs, unsortedArrs.length);
		System.out.println(Arrays.toString(unsortedArrs));
	}

	private static void bubbleSortRecursive(int[] unsortedArrs, int length) {

		if (length < 2) {
			return;
		}
		for (int j = 1; j < unsortedArrs.length; j++) {
			if (unsortedArrs[j - 1] > unsortedArrs[j]) {
				int temp = unsortedArrs[j - 1];
				unsortedArrs[j - 1] = unsortedArrs[j];
				unsortedArrs[j] = temp;
			}
		}
		bubbleSortRecursive(unsortedArrs, length - 1);

	}

	private static int[] bubbleSort(int[] unsortedArrs) {
		for (int i = 0; i < unsortedArrs.length; i++) {
			for (int j = 1; j < unsortedArrs.length; j++) {
				if (unsortedArrs[j - 1] > unsortedArrs[j]) {
					int temp = unsortedArrs[j - 1];
					unsortedArrs[j - 1] = unsortedArrs[j];
					unsortedArrs[j] = temp;
				}
			}
		}
		return unsortedArrs;
	}
}
