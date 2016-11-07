/**
 * 
 */
package com.subrat.recursion;

/**
 * @author sparida
 *
 */
public class TotalNoOfBinarySearchTreeWithNKeys {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TotalNoOfBinarySearchTreeWithNKeys totalNoOfBinarySearchTreeWithNKeys = new TotalNoOfBinarySearchTreeWithNKeys();
		int no = totalNoOfBinarySearchTreeWithNKeys.totalNoOfBinarySearchTree(6);
		System.out.println(no);
	}
	
	private  Integer totalNoOfBinarySearchTree(int n){
		
		int total = 0;
		int left=0;
		int right = 0;
		
		if(n==0 || n==1){
			return 1;
		}
		for (int i = 1; i <=n; i++) {
			left = totalNoOfBinarySearchTree(i-1);
			right = totalNoOfBinarySearchTree(n-i);
			total = total+left*right;
		}
		return total;
		
	}

}
