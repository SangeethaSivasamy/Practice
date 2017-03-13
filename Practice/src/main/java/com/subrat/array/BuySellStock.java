/**
 * 
 */
package com.subrat.array;

/**
*
* Buy and sell the stock
* https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
* Solution: keep the track of the min so far
* 
* Complexity Analysis
Time complexity : o(n)- Only a single pass is needed.
Space complexity : O(1)
Only two temp variables are used.
*
*/


public class BuySellStock {


   /**
    * eg.      7  1  5  3  6  4
    * cache    0 -6  4  2  5  3
    * @param arr of profit
    * @return maximum profit that can be made
    */
   public static int profit(int[] arr){
       if(arr == null || arr.length <= 1){
           return 0;
       }

       int current = arr[0];
       int maxProfit = 0;

       for (int i = 1; i < arr.length; ++i){
           maxProfit = Math.max(maxProfit, arr[i]-current);
           current = Math.min(current, arr[i]);
       }

       return maxProfit;
   }


   public static void main(String[] args) {
       int[] arr = new int[]{7, 1, 5, 3, 6, 4};
       System.out.println(profit(arr));
   }

}