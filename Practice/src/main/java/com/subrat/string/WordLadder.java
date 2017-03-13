/**
 * 
 */
package com.subrat.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author sparida
 * 
 * http://www.programcreek.com/2012/12/leetcode-word-ladder/
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that only one letter can be changed at a time and each intermediate word must exist in the dictionary. For example, given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.

Analysis

UPDATED on 06/07/2015.

So we quickly realize that this is a search problem, and breath-first search guarantees the optimal solution.

word-ladder
 *
 */
public class WordLadder {
	
	private static Set<String> wordDict = new HashSet();
	
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
        queue.add(new WordNode(beginWord, 1));
 
        wordDict.add(endWord);
 
        while(!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;
 
            if(word.equals(endWord)){
                return top.noOfSteps;
            }
 
            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }
 
                    String newWord = new String(arr);
                    if(wordDict.contains(newWord)){
                        queue.add(new WordNode(newWord, top.noOfSteps+1));
                        wordDict.remove(newWord);
                    }
 
                    arr[i]=temp;
                }
            }
        }
 
        return 0;
    }
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WordLadder wordLadder = new WordLadder();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		Integer result = wordLadder.ladderLength("hit", "cog", wordDict);
		System.out.println(result);
	}
	
	static class WordNode{
		String word;
		Integer noOfSteps;
		
		public WordNode(String word, Integer noOfSteps){
			this.noOfSteps=noOfSteps;
			this.word=word;
		}
	}

}
