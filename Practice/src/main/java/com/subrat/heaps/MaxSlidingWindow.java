/**
 * 
 */
package com.subrat.heaps;

import java.util.*;

/**
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * For example, Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *
 * For example,
     Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     Window position                Max
     ---------------               -----
     [1  3  -1] -3  5  3  6  7      3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7
     Therefore, return the max sliding window as [3,3,5,5,6,7].
 *
 *
 * http://codercareer.blogspot.com/2012/02/no-33-maximums-in-sliding-windows.html
 * Hint: Use max Heap
 */


public class MaxSlidingWindow {

    public static int[] maxSlidingWindow(int nums[], int k){

        if(nums.length < 1 || k <= 0){
            return new int[]{};
        }
        //create max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());

        int[] result = new int[nums.length - k + 1];
        int count = 0;

        for (int i = 0; i < nums.length - k + 1; i++){
            for (int j = i; j < i + k; j++){
                maxHeap.offer(nums[j]);
            }
            result[count] = maxHeap.poll();
            count++;
            maxHeap.clear();
        }
        return result;
    }


    public static void main(String args[]){
        int nums [] = {1,3,-1,-3,5,3,6,7};
        int[] result = maxSlidingWindow(nums, 3);

        for (int i = 0; i < result.length; i++)
            System.out.print(result[i]+" ");
    }
}
