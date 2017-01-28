/**
 * 
 */
package com.subrat.array;

import java.util.HashMap;

/**
 * @author sparida
 * 
 * http://krishnalearnings.blogspot.in/2016/07/largest-sub-array-with-sum-equal-to.html
 *
 */
public class ZeroSubArrayMaxLength {
	
	/*public static int maxLength(int[] array) {
        int N = array.length;
        int sum = 0, localLen = 0;
        int maxLen = 0;
        for (int i = 0; i < N; i++) {
            sum = array[i];
            localLen = 1;
            if (sum == 0 && maxLen == 0) {
                maxLen = 1;
            }
            for (int j = i + 1; j < N; j++) {
                sum = sum + array[j];
                localLen++;
                if (sum == 0 && localLen > maxLen) {
                    maxLen = localLen;
                }
            }
        }
        return maxLen;
    }*/
	
	public static int maxLength(int A[]) {
        int n = A.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        hashMap.put(0, -1); // initialization
        for (int i = 0; i < n; i++) {
            sum = sum + A[i];
            Integer pSumIndex = hashMap.get(sum);
            if (pSumIndex != null) {
                int localLength = i - pSumIndex;
                if (maxLength < localLength) {
                    maxLength = localLength;
                }
            } else {
                hashMap.put(sum, i);
            }
        }
        return maxLength;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {-12,3,1,-2,-1,1,10,0};
        int result = maxLength(array);
        System.out.println(result);

	}

}
