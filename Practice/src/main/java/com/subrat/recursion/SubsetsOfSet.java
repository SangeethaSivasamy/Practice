/**
 * 
 */
package com.subrat.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sparida
 * 
 * It's very simple to do this recursively. The basic idea is that for each element, the set of subsets can be divided equally into those that contain that element and those that don't, 
 * and those two sets are otherwise equal.
For n=1, the set of subsets is {{}, {1}}
For n>1, find the set of subsets of 1,...,n-1 and make two copies of it. For one of them, add n to each subset. Then take the union of the two copies.

To make it crystal clear:
The set of subsets of {1} is {{}, {1}}
For {1, 2}, take {{}, {1}}, add 2 to each subset to get {{2}, {1, 2}} and take the union with {{}, {1}} to get {{}, {1}, {2}, {1, 2}}
Repeat till you reach n
 * 
 * 
 * 
 * Another way of doing this is here - https://cheonhyangzhang.wordpress.com/2015/09/25/78-leetcode-java-subsets-medium/
 * 
 */
public class SubsetsOfSet {
	
	public List<List<Integer>> subsets(int[] nums) {
        if (nums == null)
            return null;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> toAddAll = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            toAddAll.clear();
            //get sets that are already in result
            for (List<Integer> a : result) {
                List<Integer> toAdd = new ArrayList<Integer>(a);
                toAdd.add(nums[i]);
                toAddAll.add(toAdd);
            }
            result.addAll(toAddAll);
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		SubsetsOfSet subsetsOfSet = new SubsetsOfSet();
		int[] array = new int[]{1,2,3};
		List<List<Integer>> result =subsetsOfSet.subsets(array);

	}

}
