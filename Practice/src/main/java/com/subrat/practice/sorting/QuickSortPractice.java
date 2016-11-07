/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class QuickSortPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{7,1,9,2,33,2,89,4,12};
		QuickSortPractice quickSortPractice = new QuickSortPractice();
		quickSortPractice.sort(array);
		System.out.println(Arrays.toString(array));

	}

	private void sort(int[] array) {
		int length = array.length;
		quickSort(array,0,length-1);
		
	}

	private void quickSort(int[] array, int start, int end) {
		
		if (start<end) {
			int partitionIndex = partition(array,start,end);
			quickSort(array, start, partitionIndex-1);
			quickSort(array, partitionIndex+1, end);
		}
		
	}

	private int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i = start;
		for (int j = start; j < end; j++) {
			if (array[j] < pivot) {
				int temp = array[i];
				array[i]=array[j];
				array[j]=temp;
				i=i+1;
			}
		}
		
		array[end]=array[i];
		array[i]=pivot;
		return i;
	}

}
