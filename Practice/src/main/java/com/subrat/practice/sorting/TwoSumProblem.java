/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class TwoSumProblem {
	
	public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(target - numbers[i], i);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                if (map.get(numbers[i]) != i) {
                    return new int[]{i + 1, map.get(numbers[i]) + 1};
                }
            }
        }
        return new int[2];
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{-9,-4,-2,3,4,5,6,7,9,2};
		TwoSumProblem twoSumProblem = new TwoSumProblem();
		int[] result =twoSumProblem.twoSum(array, 0);
		System.out.println();

	}

}
