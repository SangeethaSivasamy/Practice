/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *A child is running up a staircase  with n steps, and he can hop 1 steps, 2 steps, or 3 steps at a time. Implement a method to count
 *how many possible ways the child can run up the stairs.
 *
 *http://ms.appliedprobability.org/data/files/Articles%2047/47-1-4.pdf
 *
 *https://www.youtube.com/watch?v=CFQk7OQO_xM
 */
public class StairCaseProblem {
	
	public static void main(String[] args) {
		
		StairCaseProblem stairCaseProblem = new StairCaseProblem();
		Integer recursiveResult = stairCaseProblem.countPathsRecursive(15);
		System.out.println(recursiveResult);
		Integer memoizationResult = stairCaseProblem.countPathsMemoization(15);
		System.out.println(memoizationResult);
		Integer dpResult = stairCaseProblem.countPathsDP(15);
		System.out.println(dpResult);
		Integer dpResultIterative = stairCaseProblem.countPathsDPIterative(15);
		System.out.println(dpResultIterative);
	}
	
	//time vomplexity O(3 to the power n)-->expontial so not a good solution
		private static int countPathsRecursive(int steps){
			if(steps<0){
				return 0;
			}
			else if(steps==0){
				return 1;
			}
			
			return countPathsRecursive(steps-1)+countPathsRecursive(steps-2)+countPathsRecursive(steps-3);
		}

	//time complexity is linear but we are taking extra space with linear space, i.e space is O(n)
	private Integer countPathsMemoization(int steps) {
		if(steps<0){
			return 0;
		}
		return countPathsMemoization(steps,new int[steps+1]);
	}


	private Integer countPathsMemoization(int steps, int[] memo) {
		if(steps<0){
			return 0;
		}
		else if(steps==0){
			return 1;
		}
		if(memo[steps]==0){
			memo[steps]=countPathsMemoization(steps-1,memo)+countPathsMemoization(steps-2,memo)+countPathsMemoization(steps-3,memo);
		}
		return memo[steps];
	}
	//time complexity is linear but we are taking extra space with linear space, i.e space is O(n)
	private Integer countPathsDP(int steps) {
		if(steps<0){
			return 0;
		}
		else if(steps<=1){
			return 1;
		}
		int[] paths= new int[steps+1];
		paths[0]=1;
		paths[1]=1;
		paths[2]=2;
		for (int i = 3; i <=steps; i++) {
			paths[i]=paths[i-1]+paths[i-2]+paths[i-3];
		}
		return paths[steps];
	}
	private Integer countPathsDPIterative(int steps) {
		if(steps<0){
			return 0;
		}
		else if(steps<=1){
			return 1;
		}
		int[] paths = {1,1,2};
		for (int i = 3; i <=steps; i++) {
			int count = paths[2]+paths[1]+paths[0];
			paths[0]=paths[1];
			paths[1]=paths[2];
			paths[2]=count;
		}
		
		return paths[2];
	}

}
