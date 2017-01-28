/**
 * 
 */
package com.subrat.dynamicProgramming;

import java.util.Arrays;

/**
 * Find the largest square submatrix of all 1s in a matrix of 1s and 0s.
 */
public class SquareSubMatrix {

    public static int subMatrix(int[][] arr){

        int x = arr.length;
        if(x == 0){
            return 0;
        }

        int y = arr[0].length;
        if(y == 0){
            return 0;
        }

        int[][] cache = new int[x][y];
        int max = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){

                if(i == 0 || j == 0){
                    cache[i][j] = arr[i][j];
                }
                else if(arr[i][j] == 1){
                    cache[i][j] = Math.min(Math.min(arr[i-1][j],arr[i][j-1]),arr[i-1][j-1]) + 1;
                }

                if(cache[i][j] > max){
                    max = cache[i][j];
                }

            }
        }

        System.out.println(Arrays.deepToString(cache));
        return max;
    }

    public static void main(String[] args) {
        int matrix[][] = {
             {0, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0}};

        System.out.print(subMatrix(matrix));
    }
}
