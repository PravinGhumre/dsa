package com.dsa.book.sorting;

import java.util.Arrays;

public class SortingAlgos {

	public static void main(String[] args) {

		// Bubble Sort
		int[] unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		int[] sortedArray = bubbleSort(unsortedArrs);
		System.out.println(" sortedArray " + Arrays.toString(sortedArray));

		unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		int[] sortedArrayRecur = bubbleSortRecur(unsortedArrs,
				unsortedArrs.length);
		System.out.println(
				" sortedArrayRecur " + Arrays.toString(sortedArrayRecur));

		// Selection Sort
		unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		int[] selectionSort = selectionSort(unsortedArrs);
		System.out.println(" selectionSort " + Arrays.toString(selectionSort));

		// Insertion Sort
		unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		int[] insertionSort = insertionSort(unsortedArrs);
		System.out.println(" insertionSort " + Arrays.toString(insertionSort));

		// Merge Sort
		unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		mergeSort(unsortedArrs, 0, unsortedArrs.length - 1);
		System.out.println(" mergeSort " + Arrays.toString(unsortedArrs));

		// Quick Sort
		unsortedArrs = new int[]{8, 9, 4, 6, 2, 7, 5, 3, 1};
		quickSort(unsortedArrs, 0, unsortedArrs.length - 1);
		System.out.println(" quickSort " + Arrays.toString(unsortedArrs));

		// Program to find minimum number of platforms
	}

	private static void quickSort(int[] unsortedArrs, int lowerIdx,
			int upperIdx) {
		if (lowerIdx < upperIdx) {
			int pi = partition(unsortedArrs, lowerIdx, upperIdx);
			quickSort(unsortedArrs, lowerIdx, pi - 1);
			quickSort(unsortedArrs, pi + 1, upperIdx);
		}
	}

	private static int partition(int[] unsortedArrs, int lowerIdx,
			int upperIdx) {
		int left, right, pivotItem = unsortedArrs[lowerIdx];
		left = lowerIdx;
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
		unsortedArrs[lowerIdx] = unsortedArrs[right];
		unsortedArrs[right] = pivotItem;
		return right;
	}
	private static void swap(int[] unsortedArrs, int left, int right) {
		int temp = 0;
		temp = unsortedArrs[left];
		unsortedArrs[left] = unsortedArrs[right];
		unsortedArrs[right] = temp;
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

		for (int i = 0; i < rightArr.length; i++) {
			rightArr[i] = unsortedArrs[middleIdx + 1 + i];
		}

		int i = 0;
		int j = 0;
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

	private static int[] insertionSort(int[] unsortedArrs) {
		for (int i = 1; i < unsortedArrs.length; i++) {
			int hole = i;
			int valueToBeInserted = unsortedArrs[i];
			while (hole > 0 && unsortedArrs[hole - 1] > valueToBeInserted) {
				unsortedArrs[hole] = unsortedArrs[hole - 1];
				hole = hole - 1;
			}
			unsortedArrs[hole] = valueToBeInserted;
		}
		return unsortedArrs;
	}

	private static int[] selectionSort(int[] unsortedArrs) {
		for (int i = 0; i < unsortedArrs.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < unsortedArrs.length; j++) {
				if (unsortedArrs[j] < unsortedArrs[minIndex]) {
					minIndex = j;
				}
			}
			int temp = unsortedArrs[minIndex];
			unsortedArrs[minIndex] = unsortedArrs[i];
			unsortedArrs[i] = temp;
		}
		return unsortedArrs;
	}

	private static int[] bubbleSortRecur(int[] unsortedArrs, int length) {
		if (length < 2) {
			return unsortedArrs;
		}
		for (int j = 1; j < unsortedArrs.length; j++) {
			if (unsortedArrs[j - 1] > unsortedArrs[j]) {
				int temp = unsortedArrs[j - 1];
				unsortedArrs[j - 1] = unsortedArrs[j];
				unsortedArrs[j] = temp;
			}
		}
		return bubbleSortRecur(unsortedArrs, length - 1);
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
