/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class MaxProductSubArray {
	
	static int[] input = new int[]{-1,-2,0,8,5,0};
	
	public int maxProduct(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], result = A[0];  //min = A[0], 
        for (int i = 1; i < A.length; i++) {
            //int temp = max;
           // max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
        	 max = Math.max(max * A[i],A[i]);
           // min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxProductSubArray maxProductSubArray = new MaxProductSubArray();
		Integer result = maxProductSubArray.maxProduct(input);
		System.out.println(result);

	}

}
