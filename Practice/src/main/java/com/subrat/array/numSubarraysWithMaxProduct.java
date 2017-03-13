/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class numSubarraysWithMaxProduct {
	
	public static int numSubarraysWithMaxProductBruteForce(int[] array, int maxProduct) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null!");
        }
 
        int n = array.length;
        int numSubarraysWithMaxProduct = 0;
 
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                int product = 1;
 
                for (int k = i; k <= j; ++k) {
                    product *= array[k];
                }
 
                if (product < maxProduct) {
                    ++numSubarraysWithMaxProduct;
                } else {
                    break;
                }
            }
        }
 
        return numSubarraysWithMaxProduct;
    }
	
	public static int numSubarraysWithMaxProductSlidingWindow(int[] array, int maxProduct) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null!");
        }
 
        int n = array.length;
        int numSubarraysWithMaxProduct = 0;
        int product = 1;
 
        for (int left = 0, right = -1; left < n; ++left) {
            // I have rewritten
            // "product * array[right + 1] < maxProduct"
            // as
            // "array[right + 1] < Math.ceil((double)maxProduct / product)"
            // to avoid the overflow that can result from multiplication.
            while (right + 1 < n && array[right + 1] < Math.ceil((double)maxProduct / product)) {
                product *= array[++right];
            }
 
            int subarraySize = right - left + 1;
            numSubarraysWithMaxProduct += subarraySize;
 
            product /= array[left];
        }
 
        return numSubarraysWithMaxProduct;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        int[] array = { 3, 2, 1, 3, 2, 10, 5 };
        int maxProduct = 65;
        //System.out.println(numSubarraysWithMaxProductSlidingWindow(array, maxProduct));
        System.out.println(numSubarraysWithMaxProductBruteForce(array, maxProduct));
    }

}
