package com.subrat.array;

/**
 * Count the number of ones in the number
 * Solution: pretty standard problem, key is to AND the number by subtracting one
 */

public class HammingWeight {

    public static int BitCount(int num){
        int count = 0;
        while (num > 0){
            count++;
            num = num & (num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(BitCount(15));
    }
}