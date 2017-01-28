package com.subrat.string;

import java.util.Arrays;

/*
 * 
 * For example, if the input string is "  Hi, How are you?  " 
 * then the output returned should be "Hi,Howareyou?"
 * 
 * For a given string, if there are 'j' number of spaces to the left of the character at index 'i', 
 * then that 'i'th character would be placed at (i-j)th index after removing all spaces from the given string.
 * 
 * 
 * Time Complexity is O(n)
Space Complexity is O(n)
 * 
 */

public class RemoveSpaces
{
    // removes spaces from given string
    public static String removeSpaces(String str)
    {
        char[] charArray = str.toCharArray();
         
        int numSpaces = 0; // number of spaces before 'i'th character  
        for (int i = 0; i < charArray.length; i++)
        {
            // count number of spaces
            if (charArray[i] == ' ') 
            {
                numSpaces += 1;
            }
            // put 'i'th character into its correct position after removing spaces before it
            else
            {
                charArray[i-numSpaces] = charArray[i];
            }
        }
         
        // all the spaces are moved towards the end of the string. 
        // Create new string by using non-space characters
        charArray = Arrays.copyOf(charArray, charArray.length - numSpaces);
         
        return new String(charArray);
    }
     
     
    public static void main(String[] args)
    {
        String strWithSpaces    = "  Hi there, how  are you   doing? ";
        String strWithoutSpaces = removeSpaces(strWithSpaces);
         
        System.out.println(strWithoutSpaces);
    }
}