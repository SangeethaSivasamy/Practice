package com.subrat.array;

import java.util.Arrays;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i]. Solve it without division and in O(n) For example, given [1,2,3,4],
 * return [24,12,8,6]
 */

public class ProductArray {

	/*
	 * @param nums array of numbers
	 * 
	 * @return array of result
	 */
	public static int[] productExceptSelf(int[] nums) {

		int[] result = new int[nums.length];

		/*
	        * Propagate sum
	        * nums -    1       2       3          4       5
	        *              ↘        ↘       ↘       ↘
	        * result-      ->   1  ->  1*2   -> 1*2*3  -> 1*2*3*4
	        * */
		result[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i - 1] * nums[i - 1];
		}

		int right = nums[nums.length - 1];
		for (int i = nums.length - 2; i >= 0; i--) {
			result[i] = result[i] * right;
			right = right * nums[i];
		}

		return result;
	}

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3, 4, 5 };
		int[] result = productExceptSelf(num);
		System.out.println(Arrays.toString(result));
	}

}