/**
 * 
 */
package com.subrat.array;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
 * 
 * We can also use hashing. The idea is to iterate through the array and for every element arr[i], calculate sum of elements form 0 to i 
 * (this can simply be done as sum += arr[i]). If the current sum has been seen before, then there is a zero sum array. Hashing is used to store the sum values, 
 * so that we can quickly store sum and find out whether the current sum is seen before or not.
 */
public class ZeroSumSubArray {


    public static int[] zeroSum(int[] arr){

        HashMap<Integer, Integer> sums = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++){

            Integer oldIndex = sums.get(sum);
            if (oldIndex == null){
                sums.put(sum,i);
                sum = sum + arr[i];
            } else {
                return Arrays.copyOfRange(arr, oldIndex, i);
            }
        }
        return null;
    }


    public static void main(String[] args) {

        int[] arr = {4, 2, -3, 1, 6};//{1, 2, -5, 1, 2, -1};
    	//int[] arr = {5, 1, 2, -3, 7, -4};
        System.out.println(Arrays.toString(zeroSum(arr)));

    }
}