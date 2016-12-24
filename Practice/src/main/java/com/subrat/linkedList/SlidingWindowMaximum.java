/**
 * 
 */
package com.subrat.linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;



/**
 * @author sparida
 *
 */
public class SlidingWindowMaximum {

	private int[] maxSlidingWindow(int[] nums, int k) {

        // heapMax:
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                // reversing the default behavior which is heapMin
                return num2 - num1;
            }
        };

        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, comparator);

        int i = 0;
        int count = 0;
        while (i <= nums.length - k) {

            for (int j = i; j < k + i; j++) {
                pq.add(nums[j]);
            }

            res[count] = pq.poll();

            count++;
            i++;
            pq.clear();
        }

        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {7,3,-1,-3,5,3,6,1};
		SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
		int[] answer = slidingWindowMaximum.maxSlidingWindow(nums, 3);
		for (int i : answer) {
			System.out.print(i+",");
		}
		
	}    
}
