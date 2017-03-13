/**
 * 
 */
package com.subrat.array;

import java.util.Arrays;



/**
 * @author sparida
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * 1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4

O(1) space and in O(n) time
 *
 */
public class RotateArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RotateArray rotateArray = new RotateArray();
		int[] array = {1,2,3,4,5,6,};
		int[] result = rotateArray.rotate(array,2);
		System.out.println(Arrays.toString(result));

	}

	private int[] rotate(int[] array,int order) {
		
		if(array==null || array.length<1 || order<0){
			throw new IllegalArgumentException("Illegal argument!");
		}
		
		if(order > array.length){
			order = order % array.length;
		}
		
		int a = array.length-order;
		reverse(array,0,a-1);
		reverse(array, a, array.length-1);
		reverse(array, 0, array.length-1);
		
		return array;
	}

	private void reverse(int[] array, int i, int j) {
		
		if(array==null || array.length ==1){
			return;
		}
		
		while(i<j){
			int temp = array[i];
			array[i]=array[j];
			array[j]=temp;
			i++;
			j--;
		}
		
		
	}

}
