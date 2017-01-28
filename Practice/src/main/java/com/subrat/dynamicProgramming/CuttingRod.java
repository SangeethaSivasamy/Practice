package com.subrat.dynamicProgramming;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 * 
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20


We can get the best price by making a cut at different positions and comparing the values obtained after a cut. We can recursively call the same function for a piece obtained after a cut.

Let cutRoad(n) be the required (best possible price) value for a rod of lenght n. cutRod(n) can be written as following.

cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}


Considering the above implementation, following is recursion tree for a Rod of length 4.

cR() ---> cutRod() 

                             cR(4)
                  /        /      \     \
                 /        /        \      \
             cR(3)       cR(2)     cR(1)   cR(0)
            /  |  \       /  \       |
           /   |   \     /    \      |  
      cR(2) cR(1) cR(0) cR(1) cR(0) cR(0)
     / \       |          |
    /   \      |          |   
  cR(1) cR(0) cR(0)      cR(0)
   /
 /
CR(0)
 * 
 */
public class CuttingRod {


    static public int recursion(int[] values, int n){

        if(n<=0){
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for(int i=0; i< n; i++){
            max = Math.max(max, values[i] + recursion(values, n-i-1));
        }

        return max;
    }


    static public int dp(int[] values, int n){

        int cache[] = new int[n+1];
       // cache[0] = 0;

        for(int i=1; i <= n; ++i){
            int max = Integer.MIN_VALUE;
            for(int j=0; j < i; ++j){
                    max = Math.max(max, values[j] + cache[i-j-1]);
            }
            cache[i] = max;
        }

        return cache[n];
    }

    public static void main(String[] args) {

        int[] values = new int[]{1, 5, 8, 9, 10, 17, 17, 20};
        int result = 0;
        result = recursion(values, values.length);
        System.out.println(result);

        result = dp(values,values.length);
        System.out.println(result);

    }

}