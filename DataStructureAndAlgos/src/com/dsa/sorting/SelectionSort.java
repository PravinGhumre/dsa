package com.dsa.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {

		int[] unsortedArrs = { 8, 9, 4, 6, 2, 7, 5, 3, 1 };
		int[] sortedArray = selectionSort(unsortedArrs);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] selectionSort(int[] unsortedArrs) {
		for (int i = 0; i < unsortedArrs.length - 1; i++) {
			int midIndex = i;
			for (int j = i + 1; j < unsortedArrs.length; j++) {
				if (unsortedArrs[j] < unsortedArrs[midIndex]) {
					midIndex = j;
				}
			}
			int temp = unsortedArrs[midIndex];
			unsortedArrs[midIndex] = unsortedArrs[i];
			unsortedArrs[i] = temp;
		}
		return unsortedArrs;
	}

}
