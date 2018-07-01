package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] unsortedArrs = { 8, 9, 4, 6, 2, 7, 5, 3, 1 };
		int[] sortedArray = insertionSort(unsortedArrs);
		System.out.println(Arrays.toString(sortedArray));
	}

	private static int[] insertionSort(int[] unsortedArrs) {
		for (int i = 0; i < unsortedArrs.length; i++) {
			int valueToBeInserted = unsortedArrs[i];
			int hole = i - 1;
			while (hole >= 0 && unsortedArrs[hole] > valueToBeInserted) {
				unsortedArrs[hole + 1] = unsortedArrs[hole];
				hole = hole - 1;
			}
			unsortedArrs[hole + 1] = valueToBeInserted;
		}
		return unsortedArrs;
	}

}
