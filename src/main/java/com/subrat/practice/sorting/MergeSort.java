/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class MergeSort {

	
	

	Comparable[] MergeSort(Comparable[] array) {

		int length = array.length;
		Comparable[] tempArray = new Comparable[length];
		tempArray = sorting(array,tempArray,0, length - 1);

		return tempArray;

	}

	private Comparable[] sorting(Comparable[] array, Comparable[] tempArray,int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			sorting(array,tempArray,start, mid);
			sorting(array,tempArray,mid + 1, end);
			tempArray = mergeSorting(array,tempArray,start, mid, end);
		}
		return tempArray;

	}

	private Comparable[] mergeSorting(Comparable[] array, Comparable[] tempArray, int start, int mid, int end) {
		int j = mid + 1;
		int k = start;
		int i = start;
		while (k <= mid && j <= end) {
			if (array[start].compareTo(array[j])<=0) {
				tempArray[k] = array[start];
				k++;
				start++;
			} else {
				tempArray[k] = array[j];
				k++;
				j++;
			}

		}

		while (start <= mid) {
			tempArray[k++] = array[start++];
			
		}

		while (j <= end) {
			tempArray[k++] = array[j++];
		}
		return tempArray;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeSort sort = new MergeSort();
		Comparable[] array = new Comparable[] { 89, 5, 1, 2, 1, 7, 45, 11, 34, 9, 2, 1 };
		Comparable[] data = sort.MergeSort(array);
		System.out.println(Arrays.toString(data));

	}

}
