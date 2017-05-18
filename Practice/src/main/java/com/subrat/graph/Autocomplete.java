/**
 * 
 */
package com.subrat.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author sparida
 * Write an autocomplete class that returns all dictionary words with a given prefix.
 * dict:   {"abc", "acd", "bcd", "def", "a", "aba"}
 
prefix: "a" -> "abc", "acd", "a", "aba"
prefix: "b" -> "bcd"
 *
 */
public class Autocomplete {
	
	private TrieNode root;

	private  class TrieNode{
		String prefix;
		Boolean endOfWord=null;
		Map<Character,TrieNode> children = null;
		
		private TrieNode(String prefix){
			this.prefix=prefix;
			this.children=new HashMap<Character,TrieNode>();
			this.endOfWord=false;
		}
	}
	
	public Autocomplete(String[] dict){
		root=new TrieNode("");
		for (String word : dict) {
			insertWord(word);
		}
	}
	
	
	private void insertWord(String s) {
        
		TrieNode curr = root;
        for (int i = 0; i < s.length(); i++) {
            if (!curr.children.containsKey(s.charAt(i))) {
                curr.children.put(s.charAt(i), new TrieNode(s.substring(0, i + 1)));
            }
            curr = curr.children.get(s.charAt(i));
            if (i == s.length() - 1){
            	curr.endOfWord = true;
            }
        }
    }
	
	public List<String> getAllWordsStartsWithPrefix(String prefix){
		List<String> result = new LinkedList<>();
		
		TrieNode curr = root;
		for (char ch : prefix.toCharArray()) {
			TrieNode node = curr.children.get(ch);
			if(node==null){
				return result;
			}else{
				curr=node;
			}
		}
		
		findAllChildWords(curr,result);
		return result;
		
	}


	private void findAllChildWords(TrieNode curr, List<String> result) {
		if(curr.endOfWord){
			result.add(curr.prefix);
		}
		for (Character ch : curr.children.keySet()) {
			findAllChildWords(curr.children.get(ch),result);
		}
		
	}
	

	public static void main(String[] args) {
    Autocomplete autocomplete = new Autocomplete(new String[]{"abc", "acd", "bcd", "def", "a", "aba"});
    List<String> output = autocomplete.getAllWordsStartsWithPrefix("a");
    for (String string : output) {
		System.out.println(string);
	}
        
           

	}

}
