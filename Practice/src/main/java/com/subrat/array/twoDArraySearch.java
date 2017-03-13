package com.subrat.array;

/**
 * Given an n x n matrix, where every row and column is sorted in increasing order.
 * Given a number x, how to decide whether this x is in the matrix. The designed algorithm should have linear time complexity.
 * Hint: Use staicase search
 */
public class twoDArraySearch {

    public static boolean isPresent(int[][] mat, int element){

        //if the element is smaller than the smallest and greater than the greatest element then its not present
        if (element < mat[0][0] || element > mat[mat.length-1][mat.length-1]){
            return false;
        }

        //set row and column at the last position of the 0th row
        int row = 0;
        int column = mat[0].length - 1;

        while (row <= mat.length-1 && column >=0 ){

            if (mat[row][column] == element){
                return true;
            }

            //if the element is greater search in the column down
            if (mat[row][column] < element){
                ++row;
            }

            //if the element is smaller search on the left of the position
            if (mat[row][column] > element){
                --column;
            }

        }
        return false;
    }


    public static void main(String[] args) {
        int[][] mat =  {   { 2, 6, 7, 11,20},
                { 3, 8, 10, 12, 21},
                { 4, 9, 11, 13, 22},
                { 5, 15, 16, 18, 23}
        };
        System.out.println(isPresent(mat,-89));
    }
}