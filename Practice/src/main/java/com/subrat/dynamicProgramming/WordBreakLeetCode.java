/**
 * 
 */
package com.subrat.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author sparida
 *
 */
public class WordBreakLeetCode {
	
	public List<String> wordBreak(String s, Set<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	 
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	
	static String[] wordBreak(String strWord, String[] strDict) {
		return null;


    }
	 
	public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		WordBreakLeetCode wordBreakLeetCode = new WordBreakLeetCode();
		List<String> list = wordBreakLeetCode.wordBreak("catsanddog", wordDict);
		System.out.println(list);

	}

}
