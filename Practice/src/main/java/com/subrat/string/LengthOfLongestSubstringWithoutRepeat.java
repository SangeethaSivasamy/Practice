package com.subrat.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Solution: Use HashSet
 */
public class LengthOfLongestSubstringWithoutRepeat {

    public static int lengthOfLongestSubstring(String str){
        if (str == null || str.length() == 0){
            return 0;
        }

        int start = 0;
        int end = 0;
        int maxLen = 0;

        Set<Character> set = new HashSet<>();
        for (end = 0; end < str.length(); end++){
            if (!set.contains(str.charAt(end))){
                set.add(str.charAt(end));
            } else {
                maxLen = Math.max(maxLen, end - start);
                while (start < end){
                    set.remove(str.charAt(start));
                    start ++;
                }
                start++;
            }
        }

        maxLen = Math.max(maxLen, end - start);
        return maxLen;
    }


    public static void main(String[] args) {
        String input = new String("abcabcbb");
        System.out.println(lengthOfLongestSubstring(input));
    }

}