/**
 * 
 */
package com.subrat.linkedList;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author sparida
 *
 */
public class MaximumSlidingWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {7,3,-1,-3,5,3,6,1};
		MaximumSlidingWindow maximumSlidingWindow = new MaximumSlidingWindow();
		ArrayList<Integer> answer = maximumSlidingWindow.maxSlidingWindow(nums, 3);
		for (int i : answer) {
			System.out.print(i+",");
		}
	}
	
	
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
    	ArrayList<Integer> rst = new ArrayList<Integer>();
    	if (nums == null || nums.length == 0 || k < 0) {
    		return rst;
    	}
    	Deque<Integer> deque = new LinkedList<Integer>();
    	for (int i = 0; i < k; i++) {
    		while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
    			deque.pollLast();
    		}
    		deque.offerLast(i);
    	}

    	for (int i = k; i < nums.length; i++) {
    		rst.add(nums[deque.peekFirst()]);
    		if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
    			deque.pollFirst();
    		}
    		while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
    			deque.pollLast();
    		}
    		deque.offerLast(i);
    	}
    	
    	//Last move's result needs to be recorded:
    	rst.add(nums[deque.peekFirst()]);
    	return rst;
    }
	
	
	/*public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
         
        Deque<Integer> deque = new LinkedList<Integer>();
        int[] result = new int[nums.length - k + 1];
         
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
             
            deque.addLast(i);
             
            // Remove if the size of the deque is greater than k
            if (i - deque.getFirst() + 1 > k) {
                deque.removeFirst();
            }
             
            // Add into the result
            if (i + 1 >= k) {
                result[i + 1 - k] = nums[deque.getFirst()];
            }
        }
         
        return result;
    }
*/
	/*public int[] maxSlidingWindow(int[] nums, int k) {
	    if(nums==null||nums.length==0)
	        return new int[0];
	 
	    int[] result = new int[nums.length-k+1];
	 
	    LinkedList<Integer> deque = new LinkedList<Integer>();
	    for(int i=0; i<nums.length; i++){
	        if(!deque.isEmpty()&&deque.peekFirst()==i-k) 
	            deque.poll();
	 
	        while(!deque.isEmpty()&&nums[deque.peekLast()]<nums[i]){
	            deque.removeLast();
	        }    
	 
	        deque.offer(i);
	 
	        if(i+1>=k)
	            result[i+1-k]=nums[deque.peek()];
	    }
	 
	    return result;
	}
*/
}
