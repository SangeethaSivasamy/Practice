/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * @author sparida
 *
 */
public class SortingQuick {
	
	private static int[] array = new int[]{9,5,1,23,4,12,2,90};
	//private static int[] array = new int[]{25,5,7,2,18,23,12,18};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortingQuick sort = new SortingQuick();
		sort.doSort(array);
		System.out.println(Arrays.toString(array));
	}

	private void doSort(int[] array) {
		sorting(array,0,array.length-1);
		
	}

	private void sorting(int[] array, int start, int end) {
		if(start<end){
			int partitionIndex = partition(array,start,end);
			sorting(array, start, partitionIndex-1);
			sorting(array, partitionIndex+1, end);
			//System.out.println(Arrays.toString(array));
		}
		
	}

	private int partition(int[] array, int start, int end) {
		int pivot = array[end];
		int i=start;
		for (int j = start; j <= end-1; j++) {
			if(array[j]<pivot){
				int temp = array[j];
				array[j] = array[i];
				array[i] = temp;
				i++;
			}
			
		}
		array[end] = array[i];
		array[i]=pivot;
		return i;
	}

}
