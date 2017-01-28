package com.subrat.string;

import java.util.HashSet;
import java.util.Set;
/*Given a string, find all the permutations of the string.
 * For example:
 * Input String: abc
 * Output: {bca, acb, abc, cba, bac, cab}
 *
 * 
 * 1. We use a hash set to store all permutations of the string.
2. If string is null or of 0 length, we return a hashset with "" as element 
3. We keep first character of the string and recursively call getAllPermutations on the remaining string. 
4. When the function returns, we add the first character to all positions in all the strings that we got in the hashset.
 */
public class AllPermutationsString {
     
    public static Set<String> getAllPermutations(String str) {
        // Create a hash set to prevent any duplicate entries
        Set<String> permutations = new HashSet<String>();
         
        if(str == null || str.length() == 0) {
            permutations.add("");
            return permutations;
        }
         
        char first = str.charAt(0);
        String remainingString = str.substring(1);
        Set<String> words = getAllPermutations(remainingString);
        for(String word: words) {
            for(int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                String suffix = word.substring(i);
                permutations.add(prefix + first + suffix);
            }
        }
        return permutations;
    }
     
    public static void main(String[] args) {
        String str = "abc";
        Set<String> permutations = getAllPermutations(str);
        System.out.println(permutations.toString());
    }
}
