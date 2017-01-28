/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 *
 */
public class IsPalindrome {

    public static boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end){
            while (start < end && !Character.isLetterOrDigit(str.charAt(start))){
                start++;
            }
            while (start < end && !Character.isLetterOrDigit(str.charAt(end))){
                end--;
            }
            if (Character.toLowerCase(str.charAt(start)) == Character.toLowerCase(str.charAt(end))){
                start ++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input = new String("malayalam");
        System.out.println(isPalindrome(input));
    }
}