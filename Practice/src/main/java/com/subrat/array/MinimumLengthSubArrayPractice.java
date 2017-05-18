/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class MinimumLengthSubArrayPractice {
	
	private static Integer array[] = {2,3,1,2,4,3};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MinimumLengthSubArrayPractice minimumLengthSubArrayPractice = new MinimumLengthSubArrayPractice();
		minimumLengthSubArrayPractice.findMinimumLengthSubArray(array,7);
	}

	private int[] findMinimumLengthSubArray(Integer[] array, int no) {
		
		int start = -1;
		int end = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			int currentSum = 0;
			for (int j = i; j < array.length && j-i+1<min; j++) {
				currentSum = currentSum+array[j];
				if(currentSum==no){
					start = i;
					end = j;
					min=j-i+1;
					break;
				}
			}
			
		}
		
		if(start==-1 && end==-1){
			System.out.println("fault on the array");
		}
		System.out.print("[");
		while(start<=end){
			System.out.print(start+",");
			start++;
		}
		System.out.print("]");
		
		return null;
	}

}
