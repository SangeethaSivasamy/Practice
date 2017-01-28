/**
 * 
 */
package com.subrat.array;

/**
 * Pascal’s Triangle
 * Pascal’s triangle is a triangular array of the binomial coefficients.
 * Write a function that takes an integer value n as input and prints first n lines of the Pascal’s triangle.
 * eg. row = 6
 1
 1 1
 1 2 1
 1 3 3 1
 1 4 6 4 1
 1 5 10 10 5 1

 Solution for O(n^2):
 If you observe all the left side starts with 1
 consider last row ie. row 6
 second no = firstNo * (rowno/1)
 so 5 = 1 * 5/1
 we decrease the numberator by 1 and increase denominator by 1 and multiply the the no to get next
 Ref: https://www.youtube.com/watch?v=ci-nsYi8mCE

 */

public class PascalTriangle {


    public static void printPascal(int nRows){

        int printChar = 1;
        int numerator, denominator;
        for(int row =0; row < nRows; row++){

            printChar = 1;
            numerator = row;
            denominator = 1;

            for(int col = 0; col <= row; col++){
                System.out.print(printChar + " ");
                printChar = printChar * numerator;
                printChar = printChar / denominator;
                numerator--;
                denominator++;
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascal(6);
    }

}
