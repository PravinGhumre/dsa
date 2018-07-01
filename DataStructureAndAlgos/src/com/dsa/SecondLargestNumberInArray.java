package com.dsa;

public class SecondLargestNumberInArray {

	public static void main(String[] args) {
		int[] inputArray = new int[] { 12, 23, 37, 1, 43, 18, 57, 69, 79, 88 };
		SecondLargestNumberInArray.findSecondLargestNumber(inputArray);
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
}
