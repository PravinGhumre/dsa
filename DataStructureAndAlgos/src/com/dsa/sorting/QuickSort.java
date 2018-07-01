package com.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] unsortedArrs = { 8, 9, 4, 6, 2, 7, 5, 3, 1 };
		quickSort(unsortedArrs, 0, unsortedArrs.length - 1);
		System.out.println(Arrays.toString(unsortedArrs));
	}

	private static void quickSort(int[] unsortedArrs, int loweIdx, int upperIdx) {
		if (loweIdx < upperIdx) {
			int pi = partition(unsortedArrs, loweIdx, upperIdx);

			quickSort(unsortedArrs, loweIdx, pi - 1);
			quickSort(unsortedArrs, pi + 1, upperIdx);
		}
	}

	private static int partition(int[] unsortedArrs, int loweIdx, int upperIdx) {
		
		return 0;
	}
}
