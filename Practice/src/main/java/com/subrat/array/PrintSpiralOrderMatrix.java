	/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sparida
 *
 */
public class PrintSpiralOrderMatrix {

    public static List<Integer> formSpiral(int[][] arr){

        int nRows = arr.length;
        int nCols = arr[0].length;
        List<Integer> result = new ArrayList<>();

        if(arr == null || arr.length == 0) 
        	return result;

        int top = 0;
        int bottom = nRows - 1;
        int left = 0;
        int right = nCols - 1;
        int dir = 0; // 0 - left to right, 1- top to bottom, 2 - right to left, 3 - bottom to up


        while (left <= right && top <= bottom){

            if (dir == 0){
                for (int i = left; i <= right; i++){
                    result.add(arr[top][i]);
                }
                top++;
            }

            if (dir == 1){
                for (int i = top; i <= bottom; i++){
                    result.add(arr[i][right]);
                }
                right--;
            }

            if (dir == 2){
                for (int i = right; i >= left; i--){
                    result.add(arr[bottom][i]);
                }
                bottom--;
            }

            if (dir == 3){
                for (int i = bottom; i >= top; i--){
                    result.add(arr[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return result;
    }


    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        List<Integer> result = formSpiral(matrix);

        for (int i: result){
            System.out.print(i + "-");
        }

    }

}
