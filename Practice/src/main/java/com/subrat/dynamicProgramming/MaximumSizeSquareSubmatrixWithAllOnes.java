/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 * https://www.youtube.com/watch?v=_Lf1looyJMU
 * Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

 
   0  1  1  0  1 
   1  1  0  1  0 
   0  1  1  1  0
   1  1  1  1  0
   1  1  1  1  1
   0  0  0  0  0
The maximum square sub-matrix with all set bits is

    1  1  1
    1  1  1
    1  1  1
    
    Time Complexity is O(mn) and space complexity is O(mn)
 *
 */
public class MaximumSizeSquareSubmatrixWithAllOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int matrix[][] = { { 1, 1, 0, 0, 1, 1 },
                { 0, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1 },
                { 0, 1, 1, 1, 1, 1 },
                { 1, 0, 0, 0, 1, 1 }
              };
		MaximumSizeSquareSubmatrixWithAllOnes maximumSizeSquareSubmatrixWithAllOnes = new MaximumSizeSquareSubmatrixWithAllOnes();
		System.out.println(maximumSizeSquareSubmatrixWithAllOnes(matrix));
	}

	private static int maximumSizeSquareSubmatrixWithAllOnes(int[][] matrix) {
		int maxSize = 0;
		int r = matrix.length;
		if(r==0){
			return 0;
		}
		int c = matrix[0].length;
		if(c==0){
			return 0;
		}
		
		// Step 1
        int[][] table = new int[r][c];
        
        for (int i = 0; i < r; i++) {
        	for (int j = 0; j < c; j++) {
        		// Step 2 a, keep all the values of 1st row and column as is in the table
                if (i == 0 || j == 0) {
                    table[i][j] = matrix[i][j];
                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
			}
                
             // Step 2 b
                else if (matrix[i][j] == 0) {
                    table[i][j] = 0;
                }
                
             // Step 2 c
                else {
                    table[i][j] = min(table[i - 1][j - 1], table[i - 1][j], table[i][j - 1]) + 1;
                    maxSize = table[i][j] > maxSize ? table[i][j] : maxSize;
                }
		}
		
		
	}
return maxSize;
}
	private static int min(int i, int j, int k) {
        return i <= j && i <= k ? i : (j <= i && j <= k ? j : k);
    }
 
}
