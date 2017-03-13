/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sparida
 * 
 * 
 * Find if there is a subarray with 0 sum
Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.

Examples:

Input: {4, 2, -3, 1, 6}
Output: true 
There is a subarray with zero sum from index 1 to 3.

Input: {4, 2, 0, 1, 6}
Output: true 
There is a subarray with zero sum from index 2 to 2.

Input: {-3, 2, 3, 1, 6}
Output: false
There is no subarray with zero sum.
A simple solution is to consider all subarrays one by one and check the sum of every subarray. We can run two loops: the outer loop picks a starting point i and 
the inner loop tries all subarrays starting from i . Time complexity of this method is O(n2).
We can also use hashing. The idea is to iterate through the array and for every element arr[i], calculate sum of elements form 0 to i (this can simply be done as sum += arr[i]). 
If the current sum has been seen before, then there is a zero sum array. Hashing is used to store the sum values, so that we can quickly store sum and find out whether the current 
sum is seen before or not.


 *
 */
public class SumZero {
	
	// Returns true if arr[] has a subarray with zero sum
    static Boolean printZeroSumSubarray(int arr[])
    {
        // Creates an empty hashMap hM
        Map<Integer, Integer> hM = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<>();
         
        // Initialize sum of elements
        int sum = 0;        
         
        // Traverse through the given array
        for (int i = 0; i < arr.length; i++)
        {   
            // Add current element to sum
            sum += arr[i];
             
            // Return true in following cases
            // a) Current element is 0
            // b) sum of elements from 0 to i is 0
            // c) sum is already present in hash map
            if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)  {  
            	list.add(hM.get(sum)+1);
               return true;
            }
             
            // Add sum to hash map
            hM.put(sum, i);
        }    
         
        // We reach here only when there is no subarray with 0 sum
        return false;
    } 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = {4, 2, -3, 1, 6};
        if (printZeroSumSubarray(arr))
            System.out.println("Found a subarray with 0 sum");
        else
            System.out.println("No Subarray with 0 sum");            
    }    

	}


