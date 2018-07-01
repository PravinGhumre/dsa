package com.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {

		int[] unsortedArrs = {8, 9, 4, 6, 2, 7, 5, 3, 1};
		quickSort(unsortedArrs, 0, unsortedArrs.length - 1);
		System.out.println(Arrays.toString(unsortedArrs));
	}

	private static void quickSort(int[] unsortedArrs, int loweIdx,
			int upperIdx) {
		if (loweIdx < upperIdx) {
			int pi = partition(unsortedArrs, loweIdx, upperIdx);

			quickSort(unsortedArrs, loweIdx, pi - 1);
			quickSort(unsortedArrs, pi + 1, upperIdx);
		}
	}

	private static int partition(int[] unsortedArrs, int loweIdx,
			int upperIdx) {
		int left, right, pivotItem = unsortedArrs[loweIdx];
		left = loweIdx;
		right = upperIdx;

		while (left < right) {
			while (unsortedArrs[left] <= pivotItem) {
				left++;
			}
			while (unsortedArrs[right] > pivotItem) {
				right--;
			}
			if (left < right) {
				swap(unsortedArrs, left, right);
			}
		}
		unsortedArrs[loweIdx] = unsortedArrs[right];
		unsortedArrs[right] = pivotItem;
		return right;
	}

	private static void swap(int[] unsortedArrs, int left, int right) {
		int temp = 0;
		temp = unsortedArrs[left];
		unsortedArrs[left] = unsortedArrs[right];
		unsortedArrs[right] = temp;
	}
}
