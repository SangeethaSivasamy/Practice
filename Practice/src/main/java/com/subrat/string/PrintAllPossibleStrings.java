/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 *
 */
public class PrintAllPossibleStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintAllPossibleStrings printAllPossibleStrings = new PrintAllPossibleStrings();
		String str = "ABCDE";
	    printPattern(str);
	    
	}
	// This function creates buf[] to store individual output string and uses
	// printPatternUtil() to print all permutations.
	private static void printPattern(String str) {
		
		int n = str.length();
		 
	    // Buffer to hold the string containing spaces
	    // 2n-1 characters and 1 string terminator
	    char[] buf=new char[2*n];
	 
	    // Copy the first character as it is, since it will be always
	    // at first position
	    buf[0] = str.charAt(0);
	 
	    printPatternUtil(str, buf, 1, 1, n);
		
	}
	private static void printPatternUtil(String str, char[] buf, int i, int j, int n) {
		if (i==n)
	       {
	           buf[j] = '\0';
	           System.out.println(String.valueOf(buf));
	           //cout << buff << endl;
	           return;
	         }
	 
	    // Either put the character
	    buf[j] = str.charAt(i);
	    printPatternUtil(str, buf, i+1, j+1, n);
	 
	    // Or put a space followed by next character
	    buf[j] = ' ';
	    buf[j+1] = str.charAt(i);
	 
	    printPatternUtil(str, buf, i+1, j+2, n);
		
	}

}
