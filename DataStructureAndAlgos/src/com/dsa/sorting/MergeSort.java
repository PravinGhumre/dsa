package com.dsa.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] unsortedArrs = {8, 9, 4, 6, 2, 7, 5, 3, 1};
		mergeSort(unsortedArrs, 0, unsortedArrs.length - 1);
		System.out.println("mergeSort " + Arrays.toString(unsortedArrs));
	}

	private static void mergeSort(int[] unsortedArrs, int lowerIdx,
			int upperIdx) {
		if (lowerIdx < upperIdx) {
			int middleIdx = lowerIdx + (upperIdx - lowerIdx) / 2;
			mergeSort(unsortedArrs, lowerIdx, middleIdx);
			mergeSort(unsortedArrs, middleIdx + 1, upperIdx);

			merge(unsortedArrs, lowerIdx, middleIdx, upperIdx);
		}
	}

	private static void merge(int[] unsortedArrs, int lowerIdx, int middleIdx,
			int upperIdx) {

		int leftArrSize = middleIdx - lowerIdx + 1;
		int rightArrSize = upperIdx - middleIdx;

		int[] leftArr = new int[leftArrSize];
		int[] rightArr = new int[rightArrSize];

		for (int i = 0; i < leftArr.length; i++) {
			leftArr[i] = unsortedArrs[lowerIdx + i];
		}

		for (int j = 0; j < rightArr.length; j++) {
			rightArr[j] = unsortedArrs[middleIdx + 1 + j];
		}

		int i = 0, j = 0;
		int k = lowerIdx;

		while (i < leftArrSize && j < rightArrSize) {
			if (leftArr[i] < rightArr[j]) {
				unsortedArrs[k] = leftArr[i];
				i++;
			} else {
				unsortedArrs[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < leftArrSize) {
			unsortedArrs[k] = leftArr[i];
			i++;
			k++;
		}

		while (j < rightArrSize) {
			unsortedArrs[k] = rightArr[j];
			j++;
			k++;
		}
	}

}
