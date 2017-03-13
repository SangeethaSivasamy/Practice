/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Rotate 2D matrix
 * 
 */

public class RotateMatrix {

    public static void rotateMatrix(List<List<Integer>> matrix){
        int size = matrix.size() - 1;
        for (int i = 0; i < matrix.size()/2; i++){
            for (int j = i; j < size - i; j++){
                int temp1 = matrix.get(size - j).get(i);
                int temp2 = matrix.get(size - i).get(size - j);
                int temp3 = matrix.get(j).get(size - i);
                int temp4 = matrix.get(i).get(j);

                matrix.get(i).set(j,temp1);
                matrix.get(size - j).set(i, temp2);
                matrix.get(size - i).set(size - j, temp3);
                matrix.get(j).set(size - i,temp4);
            }
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();

        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,2,3));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(4,5,6));
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(7,8,9));
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        System.out.println(matrix);
        rotateMatrix(matrix);
        System.out.println(matrix);
    }
}