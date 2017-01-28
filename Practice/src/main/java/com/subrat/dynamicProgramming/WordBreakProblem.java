/**
 * 
 */
package com.subrat.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author sparida
 *
 */
public class WordBreakProblem {
	 
    private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays", "dynamic", "heaps", "IDeserve", "learn", "learning", "linked", "list", "platform", "programming", "stacks", "trees"));
 
    public static boolean hasValidWords(String words) {
         
        // Empty string
        if(words == null || words.length() == 0) {
            return true;
        }
 
        int n = words.length();
        boolean[] validWords = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dictionary.contains(words.substring(0, i + 1))) {
                validWords[i] = true;
            }
            if (validWords[i] == true) {
                for (int j = i + 1; j < n; j++) {
                    if (dictionary.contains(words.substring(i + 1, j + 1))) {
                        validWords[j] = true;
                    }
                    if (j == n - 1 && validWords[j] == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }       

    // DFS function returns an array including all substrings derived from s.
    static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s)) 
            return map.get(s);
            
        LinkedList<String>res = new LinkedList<String>();     
        if (s.length() == 0) {
            res.add("");
            return res;
        }               
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist) 
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
            }
        }       
        map.put(s, res);
        return res;
    }
 
    public static void main(String[] args) {
        /*if (hasValidWords("IDeservelearningplatform"))
            System.out.println("true");*/
        List<String> list = WordBreakProblem.wordBreak("IDeservelearningplatform", dictionary);
        for (String string : list) {
			System.out.println(string);
		}
        //else
            //System.out.println("false");
    }
}
     
