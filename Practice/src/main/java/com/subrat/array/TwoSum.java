/**
 * 
 */
package com.subrat.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {2,1,4,3,7,5};
		TwoSum twoSum = new TwoSum();
		int[] result =twoSum.twoSum(nums, 5);
		System.out.println(Arrays.toString(result));
	}

}
