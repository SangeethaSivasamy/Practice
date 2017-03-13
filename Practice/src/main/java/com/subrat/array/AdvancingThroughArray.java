package com.subrat.array;

import java.util.Arrays;
import java.util.List;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
 */
public class AdvancingThroughArray {

    public static boolean jumpArray(List<Integer> maxStepsArray){

        int lastIndex = maxStepsArray.size() - 1;
        int furthestSoFar = 0;

        for (int i = 0; i <= furthestSoFar && furthestSoFar < lastIndex; i++){
            furthestSoFar = Math.max(furthestSoFar, i + maxStepsArray.get(i));
        }

        return furthestSoFar >= lastIndex;

    }


    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(3,3,1,0,2,0,1);
        //List<Integer> input2 = Arrays.asList(3,2,0,0,2,0,1);
        List<Integer> input2 = Arrays.asList(2,3,1,1,4);

        System.out.println(jumpArray(input2));

    }
}