/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 * There are n stairs, a person standing at the bottom wants to reach the top. The person can climb either 1 stair or 2 stairs at a time. 
 * Count the number of ways, the person can reach the top.
 *https://www.youtube.com/watch?v=CFQk7OQO_xM
 *
 *
 * Recursively it can calculated very easily by f(n) = f(n-1) + f(n-2)
 * For Dp version we do not recalculate f(n-1) and f(n-2) but keep it in a and b
 */
public class NStairProblem {
	
	
	/**
     * Recursive and slow version. Recalculates same value over and over again.
     * Chokes for n greater than 60
     */
	public int fibonacciSeriesRecursive(int n) {
		if (n == 1 || n == 0) {
			return n;
		}
		return fibonacciSeriesRecursive(n - 1) + fibonacciSeriesRecursive(n - 2);
	}
	
	/**
     * DP version where we do not recalculate values but just keep last 2
     * calculate values
     */
	public int fibonacciSeries(int n) {
		int n1 = 0, n2 = 1;
		int sum;
		if (n == n1 || n == n2) {
			return n;
		}
		for (int i = 2; i <= n; i++) {
			sum = n1 + n2;
			n1 = n2;
			n2 = sum;
		}
		return n2;
	}
	
	public int countPathsDP(int steps){
		if(steps<0){
			return 0;
		}else if(steps<=1){
			return 1;
		}
		int[] paths = new int[steps+1];
		paths[0]=1;
		paths[1]=1;
		paths[2]=2;
		for (int i = 3; i <=steps; i++) {
			paths[i]=paths[i-1]+paths[i-2]+paths[i-3];
		}
		
		return paths[steps];
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NStairProblem fs = new NStairProblem();
		System.out.println(fs.fibonacciSeries(15));
		System.out.println(fs.fibonacciSeriesRecursive(15));
		System.out.println(fs.countPathsDP(15));
		

	}

}
