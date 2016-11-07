/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *
 */
public class TotalNoOfBinarySearchTreeWithNKeys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TotalNoOfBinarySearchTreeWithNKeys noOfBinartTrees = new TotalNoOfBinarySearchTreeWithNKeys();
		int no = noOfBinartTrees.noOfBinartTrees(6);
		System.out.println(no);

	}

	private int noOfBinartTrees(int n) {
		int[] array = new int[n+1];
		for (int i = 0; i <=n; i++) {
			array[i] = -1;
		}
		int no = calculateTheBinaryTrees(n,array);
		return no;
	}

	private int calculateTheBinaryTrees(int n, int[] array) {
		if(n<0){
			return -1;
		}
		else if(n==0 || n==1){
			return 1;
		}
		
		int totalNo = 0; 
		for (int i = 1; i <= n; i++) {
			if(array[i-1]==-1){
				array[i-1] = calculateTheBinaryTrees(i-1, array);
			}
			if(array[n-i]==-1){
				array[n-i]=calculateTheBinaryTrees(n-i, array);
			}
			totalNo = totalNo+array[i-1]*array[n-i];
		}
		
		return totalNo;
	}

}
