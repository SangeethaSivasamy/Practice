/**
 * 
 */
package com.subrat.array;

import java.util.Arrays;

/**
 * @author sparida
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 */
public class MoveZeros {
	
	private static int[] input = {0, 1, 0, 3, 12};
	
	public void moveZeroes(int[] nums) {
	    int i=0;
	    int j=0;
	 
	    while(j<nums.length){
	        if(nums[j]==0){
	            j++;
	        }else{
	            nums[i]=nums[j];
	            i++;
	            j++;
	        }
	    }
	 
	    while(i<nums.length){
	        nums[i]=0;
	        i++;
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MoveZeros moveZeros = new MoveZeros();
		moveZeros.moveZeroes(input);
		System.out.println(Arrays.toString(input));
	}

}
