package com.dsa.book.searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SearchingAlgorithms {

	public static void main(String[] args) {

		int[] arr = new int[]{10, 60, 50, 20, 70, 40, 90, 30, 80, 70};

		// Searching an Element
		unOrderedLinearSearch(arr, 70);// O(n^2)
		orderedLinearSearch(arr, 70);// O(n^2)
		binarySearchIterative(arr, 70);// O(logn)
		binarySearchRecursive(arr, 0, arr.length - 1, 70); // O(logn)

		// Check Duplicate Element
		checkDuplicatesBruteForce(arr);// O(n^2)
		checkDuplicatesBySorting(arr);// O(nlogn)

		// Check Max Repeated Element
		maxRepititionBruteForce(arr);// O(n^2)

		arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		sumAllNumber(arr); // O(n)

		arr = new int[]{1, 2, 3, 5, 6};

		// Find Missing Number
		findMissingNumber(arr); // O(n)
		findMissingNumberByXOR(arr); // O(n)

		arr = new int[]{1, 2, 3, 2, 1};

		// Find Number Occurring at Odd number of times
		findNumberOccurredOddTimesByXOR(arr); // O(n)

		// Find Repeated Elements
		findRepeatedElements(arr); // O(n^2)
		findRepeatedElementsBySorting(arr); // O(nlogn)

		// Find Single Number Which is not repeated
		findNonRepeatedNumberByXOR(arr);

		arr = new int[]{4, 8, 2, 11, 16,};

		// Find two elements whose sum is given number
		findTwoSumAsGivenNumber(arr, 13); // O(n^2)
		findTwoSumAsGivenNumberBySorting(arr, 13); // O(nlogn)
		findTwoSumAsGivenNumberByHashTable(arr, 13); // O(n)

		arr = new int[]{1, 60, -10, 70, -80, 85};

		// Find two elements whose sum is closed to ZERO
		findTwoSumClosetToZERO(arr);

		arr = new int[]{1, 3, 5, 5, 5, 5, 67, 123, 125};

		// Finding First and Last Occurrence of duplicate with Binary Search
		firstOccuranceOfDuplicateWithBinarySearchTree(arr, 0, arr.length - 1,
				5);
		lastOccuranceOfDuplicateWithBinarySearchTree(arr, 0, arr.length - 1, 5);

		// Segregating numbers
		arr = new int[]{1, 3, 5, 6, 7, 9, 18, 4, 2, 11};
		seggregateEvenOddNumber(arr);
		arr = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 0};
		seggregateZeroAndOnes(arr);

		arr = new int[]{45, 17, 1, 57, 33, 24, 69, 75};

		// K^th smallest/largest number in array
		findSecondLargestNumber(arr);
		findSecondSmallestNumber(arr);
		findKthSmallestNumber(arr, 3);
		findKthlargestNumber(arr, 3);

	}

	private static void sumAllNumber(int[] arr) {
		int n = arr.length;
		int sum = (n) * (n + 1) / 2;
		System.out.println(" sum " + sum);
	}

	private static void findKthlargestNumber(int[] arr, int k) {
		Integer[] arrInt = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			arrInt[i] = new Integer(arr[i]);
		}
		Arrays.sort(arrInt, Collections.reverseOrder());
		System.out.println(" Kth Largest Numner " + arrInt[k - 1]);
	}

	private static void findKthSmallestNumber(int[] arr, int k) {
		Arrays.sort(arr);
		System.out.println(" Kth Smallest Numner " + arr[k - 1]);

	}

	private static void seggregateZeroAndOnes(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			while (arr[left] % 2 == 0 && left < right) {
				left++;
			}
			while (arr[right] % 2 == 1 && left < right) {
				right--;
			}
			if (left < right) {
				arr[left] = 0;
				arr[right] = 1;
				left++;
				right--;
			}
		}
		System.out.println(" Seggregated Array " + Arrays.toString(arr));
	}

	private static void seggregateEvenOddNumber(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			while (arr[left] % 2 == 0 && left < right) {
				left++;
			}
			while (arr[right] % 2 == 1 && left < right) {
				right--;
			}
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		System.out.println(" Seggregated Array " + Arrays.toString(arr));
	}

	private static void findSecondSmallestNumber(int[] arr) {
		int smallest = Integer.MAX_VALUE;
		int secondSmallestNumber = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < smallest) {
				secondSmallestNumber = smallest;
				smallest = arr[i];

			} else if (arr[i] < secondSmallestNumber) {
				secondSmallestNumber = arr[i];
			}
		}
		System.out.println(" secondSmallestNumber " + secondSmallestNumber);
	}

	private static void findSecondLargestNumber(int[] inputArray) {
		int highestNumber = Integer.MIN_VALUE;
		int secondHighestNumber = Integer.MIN_VALUE;
		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] > highestNumber) {
				secondHighestNumber = highestNumber;
				highestNumber = inputArray[i];

			} else if (inputArray[i] > secondHighestNumber) {
				secondHighestNumber = inputArray[i];
			}
		}
		System.out.println(" secondHighestNumber " + secondHighestNumber);
	}

	private static void lastOccuranceOfDuplicateWithBinarySearchTree(int[] arr,
			int low, int high, int data) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == high && arr[mid] == data)
					|| (arr[mid] == data && arr[mid + 1] > data)) {
				System.out.println(" last occurance is " + mid);
				return;
			} else if (data >= arr[mid]) {
				lastOccuranceOfDuplicateWithBinarySearchTree(arr, mid + 1, high,
						data);
			} else {
				lastOccuranceOfDuplicateWithBinarySearchTree(arr, low, mid - 1,
						data);
			}
		}
	}

	private static void firstOccuranceOfDuplicateWithBinarySearchTree(int[] arr,
			int low, int high, int data) {
		if (high >= low) {
			int mid = low + (high - low) / 2;
			if ((mid == low && arr[mid] == data)
					|| (arr[mid] == data && arr[mid - 1] < data)) {
				System.out.println(" first occurance is " + mid);
				return;
			} else if (arr[mid] >= data) {
				firstOccuranceOfDuplicateWithBinarySearchTree(arr, low, mid - 1,
						data);
			} else {
				firstOccuranceOfDuplicateWithBinarySearchTree(arr, mid + 1,
						high, data);
			}
		}
	}

	private static void findTwoSumClosetToZERO(int[] arr) {
		int length = arr.length;
		if (length < 2) {
			System.out.println("Invalid Input !!");
			return;
		}
		int minSum, minOne, minTwo, sum;
		minOne = 0;
		minTwo = 1;
		minSum = arr[0] + arr[1];

		for (int i = 0; i < length - 1; i++) {
			for (int j = i + 1; j < length; j++) {
				sum = arr[i] + arr[j];
				if (Math.abs(minSum) > Math.abs(sum)) {
					minSum = sum;
					minOne = i;
					minTwo = j;
				}
			}
		}
		System.out.println("Numbers Found Whose Sum is Closet to ZERO : "
				+ arr[minOne] + " " + arr[minTwo]);
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private static void findTwoSumAsGivenNumberByHashTable(int[] arr, int sum) {
		int temp = 0;
		Set set = new HashSet();
		for (int i = 0; i < arr.length; i++) {
			temp = sum - arr[i];
			if (set.contains(temp)) {
				System.out.println("Numbers Found : " + temp + " " + arr[i]);
				return;
			} else {
				set.add(arr[i]);
			}
		}
		System.out.println("No Such Numbers Found !!");
	}

	private static void findTwoSumAsGivenNumberBySorting(int[] arr, int sum) {
		Arrays.sort(arr);
		int i = 0, j = 0, temp = 0;
		j = arr.length - 1;
		while (i < j) {
			temp = arr[i] + arr[j];
			if (temp == sum) {
				System.out.println("Numbers Found : " + arr[i] + " " + arr[j]);
				return;
			} else if (temp < sum) {
				i = i + 1;
			} else {
				j = j - 1;
			}
		}
		System.out.println("No Such Numbers Found !!");
	}

	private static void findTwoSumAsGivenNumber(int[] arr, int sum) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					System.out.println(
							"Numbers Found : " + arr[i] + " " + arr[j]);
					return;
				}
			}
		}
		System.out.println("No Such Numbers Found !!");
	}

	private static void findNonRepeatedNumberByXOR(int[] arr) {
		int x = arr[0];

		for (int i = 1; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		System.out.println("Single Non Repeated Number " + x);
	}

	private static void findRepeatedElementsBySorting(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println("Repeated Number " + arr[i]);
			}
		}
	}

	private static void findRepeatedElements(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println("Repeated Number " + arr[i]);
				}
			}
		}
	}

	private static void findNumberOccurredOddTimesByXOR(int[] arr) {
		int x = 0;
		for (int i = 0; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		System.out.println(" Number appears odd number of times " + x);
	}

	// O(n)
	private static void findMissingNumberByXOR(int[] arr) {
		int n = arr.length;
		int x1 = arr[0];
		int x2 = 1;

		/*
		 * For xor of all the elements in array
		 */
		for (int i = 1; i < n; i++) {
			x1 = x1 ^ arr[i];
		}

		/*
		 * For xor of all the elements from 1 to n+1
		 */
		for (int i = 2; i <= n + 1; i++) {
			x2 = x2 ^ i;
		}
		System.out.println(" Missing Number " + (x1 ^ x2));
	}

	private static void findMissingNumber(int[] arr) {
		int n = arr.length;
		int total = (n + 1) * (n + 2) / 2;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		System.out.println(" Missing Number " + (total - sum));
	}

	// O(n^2)
	private static void maxRepititionBruteForce(int[] arr) {
		int max = 0, counter = 0;
		for (int i = 0; i < arr.length; i++) {
			counter = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					counter++;
				}
			}
			if (counter > max) {
				max = counter;
			}
		}
		System.out.println(" Element is Repeated Max " + max);
	}

	// O(nlogn)
	private static void checkDuplicatesBySorting(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				System.out.println(" Duplicate Exists = " + arr[i]);
				return;
			}
		}
		System.out.println("No Duplicate Found !!");
	}

	// O(n^2)
	private static void checkDuplicatesBruteForce(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					System.out.println(" Duplicate Exists = " + arr[i]);
					return;
				}
			}
		}
		System.out.println("No Duplicate Found !!");
	}

	// O(logn)
	private static void binarySearchRecursive(int[] arr, int low, int high,
			int data) {
		int mid = low + (high - low) / 2;
		if (low > high) {
			System.out.println("No Element Found !!");
			return;
		}
		if (arr[mid] == data) {
			System.out.println(" Element Searched at index " + mid);
			return;
		} else if (arr[mid] > data) {
			binarySearchRecursive(arr, low, mid - 1, data);
		} else {
			binarySearchRecursive(arr, mid + 1, high, data);
		}
	}

	// O(logn)
	private static void binarySearchIterative(int[] arr, int data) {
		Arrays.sort(arr);
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == data) {
				System.out.println(" Element Searched at index " + mid);
				return;
			} else if (arr[mid] > data) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("No Element Found !!");
	}

	// O(n)
	private static void orderedLinearSearch(int[] arr, int value) {

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == value) {
				System.out.println(" Element Searched at index " + j);
				return;
			} else if (arr[j] > value) {
				return;
			}
		}
		System.out.println("No Element Found !!");
	}

	// O(n)
	private static void unOrderedLinearSearch(int[] arr, int value) {

		for (int j = 0; j < arr.length; j++) {
			if (arr[j] == value) {
				System.out.println(" Element Searched at index " + j);
				return;
			}
		}
		System.out.println("No Element Found !!");
	}

}
