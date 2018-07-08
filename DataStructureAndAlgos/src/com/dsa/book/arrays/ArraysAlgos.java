package com.dsa.book.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArraysAlgos {

	public static void main(String[] args) {

		ArraysAlgos aa = new ArraysAlgos();

		int[] inputArray = new int[]{1, 2, 3, 5, 6, 7};
		aa.findMissingNumberInArray(inputArray);

		inputArray = new int[]{12, 23, 37, 1, 43, 18, 57, 69, 79, 88};
		aa.findSecondLargestNumber(inputArray);
		aa.findSecondSmallestNumber(inputArray);
		// aa.swapTwoNumbersWithoutTemp();

		aa.findTwoNumberOfGivenSum(inputArray, 61);
		
		//
	}

	private void findTwoNumberOfGivenSum(int[] inputArray, int sum) {
		Integer temp = 0;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < inputArray.length; i++) {
			temp = sum - inputArray[i];
			if (set.contains(temp)) {
				System.out.println(" Two Number are " + temp + " and "
						+ inputArray[i] + " whose sum is " + sum);
				break;
			} else {
				set.add(inputArray[i]);
			}
		}
	}

	private void findMissingNumberInArray(int[] inputArray) {
		int n = inputArray.length;
		int total = (n + 1) * (n + 2) / 2;
		int sum = 0;
		for (int i = 0; i < inputArray.length; i++) {
			sum = sum + inputArray[i];
		}
		System.out.println("missing number = " + (total - sum));
	}

	@SuppressWarnings("resource")
	private void swapTwoNumbersWithoutTemp() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Two Numbers fo Swapping : ");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		System.out.println(" a " + a);
		System.out.println(" b " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println(" After Swapping a " + a);
		System.out.println(" After Swapping b " + b);
	}

	private void findSecondSmallestNumber(int[] inputArray) {
		int smallestNumber = Integer.MAX_VALUE;
		int secondSmallestNumber = Integer.MAX_VALUE;

		for (int i = 0; i < inputArray.length; i++) {
			if (inputArray[i] < smallestNumber) {
				secondSmallestNumber = smallestNumber;
				smallestNumber = inputArray[i];

			} else if (inputArray[i] < secondSmallestNumber) {
				secondSmallestNumber = inputArray[i];
			}
		}
		System.out.println(" secondSmallestNumber " + secondSmallestNumber);

	}

	private void findSecondLargestNumber(int[] inputArray) {
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
}
