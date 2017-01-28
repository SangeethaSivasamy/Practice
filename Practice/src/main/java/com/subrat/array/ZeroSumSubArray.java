/**
 * 
 */
package com.subrat.array;


import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of positive and negative numbers, find if there is a subarray (of size at-least one) with 0 sum.
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