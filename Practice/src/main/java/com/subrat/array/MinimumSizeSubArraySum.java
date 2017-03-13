/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class MinimumSizeSubArraySum {
	private static int[] array = {2,3,1,2,4,3};
	
	private int minSubArrayLen(int s, int[] nums) {
	    if(nums==null||nums.length==0)
	        return 0;
	 
	    int i=0; 
	    int j=0;
	    int sum=0;
	 
	    int minLen = Integer.MAX_VALUE;
	 
	    while(j<nums.length){
	        if(sum<s){
	            sum += nums[j];
	            j++;        
	        }else{
	            minLen = Math.min(minLen, j-i);
	            if(i==j-1)
	                return 1;
	 
	            sum -=nums[i];
	            i++;
	        }
	    }
	 
	    while(sum>=s){
	        minLen = Math.min(minLen, j-i);
	 
	        sum -=nums[i++];
	    }
	 
	    return minLen==Integer.MAX_VALUE? 0: minLen;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MinimumSizeSubArraySum minimumSizeSubArraySum = new MinimumSizeSubArraySum();
		Integer result = minimumSizeSubArraySum.minSubArrayLen(7,array);
		System.out.println(result);

	}

}
