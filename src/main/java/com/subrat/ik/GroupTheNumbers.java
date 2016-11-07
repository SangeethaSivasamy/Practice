/**
 * 
 */
package com.subrat.ik;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class GroupTheNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = new int[] { 2, 50, 30, 7, 9, 121, 881, 441 };
		GroupTheNumbers numbers = new GroupTheNumbers();
		int[] data1 = numbers.groupNumbers(data);
		System.out.println(Arrays.toString(data1));

	}

	private int[] groupNumbers(int[] intArr) {
		int end = intArr.length - 1;
		int middle = end / 2;
		int i = 0;
		int j = middle + 1;
		while (i <= middle && j <= end) {
			if (intArr[i] % 2 != 0 && intArr[j] % 2 == 0) {
				int temp = intArr[i];
				intArr[i] = intArr[j];
				intArr[j] = temp;
				i++;
				j++;

			} else if (intArr[i] % 2 == 0 && intArr[j] % 2 != 0) {
				i++;
				j++;

			} else if (intArr[i] % 2 != 0 && intArr[j] % 2 != 0) {
				j++;
			} else if (intArr[i] % 2 == 0 && intArr[j] % 2 == 0) {
				i++;
			}
		}

		return intArr;

	}

}
