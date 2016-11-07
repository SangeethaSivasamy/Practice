/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *
 */
public class LongestCommonSubSequenceRecursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSubSequenceRecursion longestCommonSubSequenceRecursion = new LongestCommonSubSequenceRecursion();
		int value =longestCommonSubSequenceRecursion.score("AGGTAB", "GXTXAYB");
		System.out.println(value);
	}

	private int score(String string, String string2) {
		char[] a= string.toCharArray();
		char[] b = string2.toCharArray();
		int value = score(a,b,0,0);
		return value;
		
		
	}

	private int score(char[] a, char[] b, int i, int j) {
		if(i>=a.length || j>=b.length){
			return 0;
		}
	else if(a[i]==b[j]){
			return 1+score(a, b,i+1,j+1);
		}
		else{
			final int x;
			final int y;
			x=score(a, b, i+1, j);
			y=score(a, b, i, j+1);
			return max(x,y);
		}
	}

	private int max(int x, int y) {
		
		return x>y?x:y;
	}

}
