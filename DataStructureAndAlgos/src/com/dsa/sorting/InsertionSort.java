package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] unsortedArrs = {8, 9, 4, 6, 2, 7, 5, 3, 1};
		int[] insertionSort = insertionSort(unsortedArrs);
		System.out.println(" insertionSort " + Arrays.toString(insertionSort));
	}

	private static int[] insertionSort(int[] unsortedArrs) {
		for (int i = 1; i < unsortedArrs.length; i++) {
			int valueToBeInserted = unsortedArrs[i];
			int hole = i;
			while (hole > 0 && unsortedArrs[hole - 1] > valueToBeInserted) {
				unsortedArrs[hole] = unsortedArrs[hole - 1];
				hole = hole - 1;
			}
			unsortedArrs[hole] = valueToBeInserted;
		}
		return unsortedArrs;
	}

}
