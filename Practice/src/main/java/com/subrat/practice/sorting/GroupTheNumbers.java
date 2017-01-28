/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class GroupTheNumbers {

	
	static int[] groupNumbers(int[] intArr) {
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
	
	public static void main(String[] args) {
		
		int[] array = new int[]{9,3,7,2,3,8};
		GroupTheNumbers groupTheNumbers = new GroupTheNumbers();
		int[] result = groupTheNumbers.groupNumbers(array);
		System.out.println(Arrays.toString(result));
	}

}
