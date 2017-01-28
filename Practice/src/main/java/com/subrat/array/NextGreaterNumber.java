package com.subrat.array;
/**
 * 
 * 
 * Given a number, finds next greater number of it using same digits. Runs in
 * O(n).
 * 
 * 
 * 1. Starting from last digit of given number, find the first digit which breaks the sorted ordering. Let the index of this found digit be 'i' and the digit be number[i].
2. Find the next greater digit in the right portion of number[i] - that is from digit at index i+1 to last digit. Let that digit be number[j] at index 'j'.
3. Swap digits at index 'i' and 'j'.
4. Sort the number from index i+1 to end index. Since this portion would be in reverse sorted order, all we need to do is reverse this portion which takes O(n) time.
Time complexity of this algorithm is O(n) with O(1) extra space.

 * 
 * if the given number is 6938652 then output would be 6952368. Here we have used two steps - 
1. Swap digit 3 and 5 which gives us number 6958632.
2. Sort digits after the digit 5(8632) which gets us to number 6952368.
 */

public class NextGreaterNumber {
	private void swap(int[] number, int i, int j) {
		int temp = number[i];
		number[i] = number[j];
		number[j] = temp;
	}

	private void sortSubarray(int[] number, int i, int j) {
		// for this sub-array, all the digits would be in there reverse sorted
		// position
		while (i < j) {
			swap(number, i, j);
			i += 1;
			j -= 1;
		}
	}

	public void findNextGreaterNumber(int[] number) {
		int lastDigitSeen = number[number.length - 1];
		int i=0;
		int j=0;
		for (i = number.length - 2; i >= 0; i--) {
			// if this digit is where the sorted ordering breaks
			if (lastDigitSeen > number[i]) {
				break;
			}
			lastDigitSeen = number[i];
		}

		if (i >= 0) // we found the digit breaking the sorted ordering
		{
			// find the next greater digit in the right sub-array from
			// number[i+1 to end]
			for (j = number.length - 1; j > i; j--) {
				if (number[j] > number[i]) {
					break;
				}
			}

			// swap digits at indices 'i' and 'j'
			swap(number, i, j);

			// sort the sub-array - number[i+1 to end]
			sortSubarray(number, i + 1, number.length - 1);
		}
	}

	public static void main(String[] args) {
		NextGreaterNumber solution = new NextGreaterNumber();

		int[] number = { 6, 9, 3, 8, 6, 5, 2 };
		//int[] number = { 6, 9, 3, 8, 4, 5, 2 };

		solution.findNextGreaterNumber(number);

		System.out.println("Next greater number is: ");
		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i]);
		}
	}
}