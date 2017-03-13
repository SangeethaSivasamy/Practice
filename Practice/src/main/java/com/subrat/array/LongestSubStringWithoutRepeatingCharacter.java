/**
 * 
 */
package com.subrat.array;

import java.util.HashSet;

/**
 * @author sparida
 * 
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 */
public class LongestSubStringWithoutRepeatingCharacter {
	
	private static String input = "abcabcdb";
	
	public int lengthOfLongestSubstring(String s) {
	    if(s==null || s.length()==0){
	        return 0;
	    }
	 
	    int start=0;
	    int max = 0;
	 
	    HashSet<Character> set = new HashSet<Character>();
	    for(int i=0; i<s.length(); i++){
	        char c = s.charAt(i);
	 
	        if(!set.contains(c)){
	            set.add(c);
	 
	            max = Math.max(max, i-start+1);
	        }else{
	            for(int j=start; j<i; j++){
	                set.remove(s.charAt(j));
	 
	                if(s.charAt(j)==c){
	                    start=j+1;
	                    break;    
	                }
	            }        
	 
	            set.add(c);
	        }
	    }
	 
	    return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubStringWithoutRepeatingCharacter longestSubStringWithoutRepeatingCharacter 
		= new LongestSubStringWithoutRepeatingCharacter();
		
		Integer result = longestSubStringWithoutRepeatingCharacter.lengthOfLongestSubstring(input);
		System.out.println(result);

	}

}
