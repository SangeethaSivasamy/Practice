/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
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
	
	public StringBuffer twoSumHash(int[] a, int sum) {

		Hashtable<Integer, ArrayList<Integer>> ht = new Hashtable<>();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < a.length; i++) {
			ArrayList<Integer> row = ht.get(a[i]);
			if (row == null) {
				row = new ArrayList<>();
				ht.put(a[i], row);
			}
			row.add(i);
		}

		for (int i = 0; i < a.length; i++) {
			ArrayList<Integer> row = ht.get(sum - a[i]);
			if (row != null) {
				Iterator<Integer> it = row.iterator();
				while (it.hasNext()) {
					int j = it.next();
					if (i < j) {
						sb.append("(" + i + ":" + a[i] + "," + j + ":" + a[j] + ")");
					}
				}
			}
		}

		return sb;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {2,1,4,3,7,5};
		TwoSum twoSum = new TwoSum();
		int[] result =twoSum.twoSum(nums, 5);
		//StringBuffer sb = twoSum.twoSumHash(nums, 5);
		//System.out.println(sb.toString());
		//System.out.println(Arrays.toString(result));
	}

}
