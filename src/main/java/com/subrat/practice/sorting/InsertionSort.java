/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class InsertionSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{8,5,1,23,4,98,1,3};
		InsertionSort insertionSort = new InsertionSort();
		int[] data = insertionSort.sort(array);
		System.out.println(Arrays.toString(data));

	}

	private int[] sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int current = array[i];
			int j = i-1;
			while(j>=0 && array[j]>current){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=current;
			
		}
		return array;
		
	}

}
