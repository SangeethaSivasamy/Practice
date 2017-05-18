/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * you may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
 *
 */
public class MergingTwoArrays {
	
	
	public void merge(int A[], int m, int B[], int n) {
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
	 
		while (k >= 0) {
			if (j < 0 || (i >= 0 && A[i] > B[j]))
				A[k--] = A[i--];
			else
				A[k--] = B[j--];
		}
	}
	
	
	public void merge_2ndway(int A[], int m, int B[], int n) {
		 
        while(m > 0 && n > 0){
            if(A[m-1] > B[n-1]){
                A[m+n-1] = A[m-1];
                m--;
            }else{
                A[m+n-1] = B[n-1];
                n--;
            }
        }
 
        while(n > 0){
            A[m+n-1] = B[n-1];
            n--;
        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
