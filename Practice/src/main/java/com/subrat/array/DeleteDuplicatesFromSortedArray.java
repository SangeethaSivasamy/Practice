package com.subrat.array;

import java.util.Arrays;

/**
 * Delete Duplicates from sorted array
 */

public class DeleteDuplicatesFromSortedArray {    
    
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        
    	int[] arr= new int[]{2,3,5,5,7,11,11,11,13};
    	int arryLength = removeDuplicates(arr);
    	System.out.println(Arrays.toString(Arrays.copyOf(arr, arryLength)));
        
        
    }
}





