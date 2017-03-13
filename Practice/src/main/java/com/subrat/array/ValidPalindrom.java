/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class ValidPalindrom {
	
	public static boolean isValidPalindrome(String s){
		if(s==null||s.length()==0) return false;
 
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.println(s);
 
		for(int i = 0; i < s.length() ; i++){
			if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
				return false;
			}
		}
 
		return true;
	}
	public static void main(String[] args) {
		ValidPalindrom validPalindrom = new ValidPalindrom();
		Boolean isValidPalindrom = validPalindrom.isValidPalindrome("Red rum, sir, is murder");
		System.out.println(isValidPalindrom);

	}

}
