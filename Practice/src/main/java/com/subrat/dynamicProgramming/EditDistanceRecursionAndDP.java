package com.subrat.dynamicProgramming;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 * 
 * https://www.youtube.com/watch?v=We3YDTzNXEk
 */

public class EditDistanceRecursionAndDP {

	/**
     * Utility function that returns the min of the three arguments
     * @param a
     * @param b
     * @param c
     * @return
     */
    private static int min(int a, int b, int c){
        return Math.min(Math.min(a,b),c);
    }

    /**
     * Utility function for the editDistanceRec, complexity- exponenetial
     * @param str1 First String
     * @param str2 Second String
     * @param len1 length, initially passed as len(str1)
     * @param len2 length, initially passed as len(str2)
     * @return min edits required
     */
    private static int editDistanceRecUtil(char[] str1, char[] str2, int len1, int len2){
    	
    	//converting empty string to str2,here we need str2.length() operation (inserting all the characters of str2 in empty string)
        if(len1 == 0){
            return len2;
        }

        if(len2 == 0){
            return len1;
        }

        //if both the characters are same, we are coping the same character from the diagonal
        if(str1[len1-1] == str2[len2-1]){
            return editDistanceRecUtil(str1,str2,len1-1,len2-1);
        }
        //if both the character are not same, then the value is ---> 1+minimum of three position data(left position, right position and diagonal position)
        return 1 + min( editDistanceRecUtil(str1, str2, len1, len2-1), // Insert operation
                        editDistanceRecUtil(str1, str2, len1-1, len2), // Remove operation
                        editDistanceRecUtil(str1, str2, len1-1, len2-1)); // Delete operation
    }

    public static int editDistanceRec(String str1, String str2){
        return editDistanceRecUtil(str1.toCharArray(), str2.toCharArray(), str1.length(), str2.length());
    }



    /**
     * Uses bottom up DP to find the edit distance
     */
    public static int dynamicEditDistance(char[] str1, char[] str2){
        int temp[][] = new int[str1.length+1][str2.length+1];
        
        for(int i=0; i < temp[0].length; i++){
            temp[0][i] = i;
        }
        
        for(int i=0; i < temp.length; i++){
            temp[i][0] = i;
        }
        
        for(int i=1; i<=str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    temp[i][j] = temp[i-1][j-1];
                }else{
                    temp[i][j] = 1 + min(temp[i-1][j-1], temp[i-1][j], temp[i][j-1]);
                }
            }
        }
        printActualEdits(temp, str1, str2);
        return temp[str1.length][str2.length];
        
    }


    public static int editDistanceDP(String str1, String str2){
        return dynamicEditDistance(str1.toCharArray(), str2.toCharArray());
    }
    
    /**
     * Prints the actual edits which needs to be done.
     */
    public static void printActualEdits(int T[][], char[] str1, char[] str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1[i-1] == str2[j-1]) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2[j-1] + " in string2 to " + str1[i-1] + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1[i-1]);
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2[j-1]);
                j = j -1;
            } else {
                throw new IllegalArgumentException("Some wrong with given data");
            }

        }
    }

    public static void main(String[] args) {
        String str1 = "abcded";
        String str2 = "azced";
        System.out.println(editDistanceRec(str1,str2));
        System.out.println(editDistanceDP(str1,str2));

    }

}