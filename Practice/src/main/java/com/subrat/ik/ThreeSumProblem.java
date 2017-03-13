/**
 * 
 */
package com.subrat.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author sparida
 * 
 * /**
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero
 *
 * Solution:
 * Sort the array
 * Then take three pointers: First @starting position, second @ First + 1 and third @last
 * if sum of first+second+third = 0 then include in the list
 * Else if sum < 0 then increment the second pointer or
 * if sum>0 then decrement the third pointer, which is pointing ot greater element
 *
 *
 *
 */
public class ThreeSumProblem {
	
	public static List<List<Integer>> calThreeSum(int arr[]){

        List<List<Integer>> result = new ArrayList<>();
        if(arr == null || arr.length < 3){
            return result;
        }

        Arrays.sort(arr);

        for(int first=0;first < arr.length-2; first++){

            if(first == 0 || arr[first] > arr[first-1]){
                int second = first + 1;
                int third = arr.length-1;

                while(second < third){
                    if (arr[first] + arr[second] + arr[third] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[first]);
                        list.add(arr[second]);
                        list.add(arr[third]);
                        result.add(list);

                        second++;
                        third--;

                        while(second < third && arr[second] == arr[second-1]){
                            second++;
                        }

                        while(second < third && arr[third] == arr[third-1]){
                            third--;
                        }
                    }
                    else if(arr[first] + arr[second] + arr[third] < 0){
                        second++;
                    }
                    else{
                        third--;
                    }

                }
            }
        }

    return result;

    }

    public static void main(String[] args) {

        int[] arr = new int[] {-1, 0, 1, 2, -1, -4};
        int target = 0;

        List<List<Integer>> result = calThreeSum(arr);

        for(int i=0; i<result.size(); i++) {
            List<Integer> temp = result.get(i);

            for(int j=0; j<temp.size(); j++) {
                System.out.print(temp.get(j) + ",");
            }

            System.out.println();
        }
    }
}
