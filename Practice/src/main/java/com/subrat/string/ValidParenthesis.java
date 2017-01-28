package com.subrat.string;

/*
 * 
 * An opening parentheses '(' should have a closing matching parentheses ')'.
Closing matching parentheses should not come before an opening parentheses.
Note: Assume that the string has alphabets and numbers and round brackets only.

For example:
((BCD)AE) - Valid
)(PH)N(X) - Invalid
 * 
 * 
 */

public class ValidParenthesis {

	public static boolean isValid(String str) {
		 
        if (str == null || str.length() == 0) {
            return true;
        }
 
        int count = 0;
        int i = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch == '(') {
                count++;
            } else if (ch == ')') {
                if (count == 0)
                    return false;
                else
                    count--;
            }
            i++;
        }
 
        if(count != 0) 
            return false;
         
        return true;
    }
     
    public static void main(String[] args) {
        String str = "((BCD)AE)";
        System.out.println("isValid: " + isValid(str));
        str = ")(PH)N(X)";
        System.out.println("isValid: " + isValid(str));
    }
}