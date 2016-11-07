/**
 * 
 */
package com.subrat.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sparida
 *
 */
public class PalindromPatitioningPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PalindromPatitioningPractice palindromPatitioningPractice = new PalindromPatitioningPractice();
		ArrayList<ArrayList<String>> list = palindromPatitioningPractice.partition("aab");
		System.out.println(list);

	}

	private ArrayList<ArrayList<String>> partition(String string) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		if(string==null || string.length()==0){
			return result;
		}
		List<String> partition = new ArrayList<>();
		addPalindrome(string,0,partition,result);
		return result;
	}

	private void addPalindrome(String string, int start, List<String> partition,
			ArrayList<ArrayList<String>> result) {
		if(start==string.length()){
			ArrayList<String> temp = new ArrayList<>(partition);
			result.add(temp);
			return ;
		}
		
		
		for (int i = start+1; i <= string.length(); i++) {
			String sub=string.substring(start, i);
			if(isPalindrome(sub)){
				partition.add(sub);
				addPalindrome(string, i, partition, result);
				partition.remove(partition.size()-1);
			}
			
		}
	}

	private boolean isPalindrome(String sub) {
		int start = 0;
		int end = sub.length()-1;
		while(start<end){
			if(sub.charAt(start)!=sub.charAt(end)){
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

}
