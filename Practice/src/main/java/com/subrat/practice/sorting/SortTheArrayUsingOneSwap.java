/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;

/**
 * Given an array where all its elements are sorted except two elements which were swapped, 
 * sort the array in linear time. Assume there are no duplicates in the array.
 * 
 * 
 * Input: A[] = [3, 8, 6, 7, 5, 9] OR [3, 5, 6, 9, 8, 7] OR [3, 5, 7, 6, 8, 9]
Output: A[] = [3, 5, 6, 7, 8, 9]
 *
 *
 *The idea is to start from the y element in the array and compare every element with its previous element. 
 *We take two pointers (say x and y) to store location of the conflict. If previous element is greater than the current element, 
 *we update x to the index of previous element and y to the index of current element. If again at some point we find that previous element 
 *is greater than the current element, we update y to index of current element. 
 *Finally, after we are done processing each adjacent pair of elements, we swap the elements present at index x and index y.
 */
public class SortTheArrayUsingOneSwap {
	
	private static int[] array = {3, 8, 6, 7, 5, 9};
	
	public static void main(String[] args) {
		SortTheArrayUsingOneSwap sortTheArrayUsingOneSwap = new SortTheArrayUsingOneSwap();
		sortTheArrayUsingOneSwap.sort(array);
		System.out.println(Arrays.toString(array));
	}

	private void sort(int[] array) {
		if(array==null || array.length==0){
			throw new IllegalArgumentException("wrong input");
		}
		
		int x = -1,y=-1;
		int pre = array[0];
		for (int i = 1; i < array.length; i++) {
			if(pre > array[i]){
				if(x==-1){
					x=i-1;
					y=i;
				}else{
					y=i;
				}
			}
			pre=array[i];
		}
		swap(array,x,y);
		
	}

	private void swap(int[] array, int x, int y) {
		int temp=array[x];
		array[x]=array[y];
		array[y]=temp;
		
	}

}
