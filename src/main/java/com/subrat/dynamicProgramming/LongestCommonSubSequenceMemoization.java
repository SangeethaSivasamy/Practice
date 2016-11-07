/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *
 */
public class LongestCommonSubSequenceMemoization {
	int[][] array = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestCommonSubSequenceMemoization longestCommonSubSequenceMemoization = new LongestCommonSubSequenceMemoization();
		int value = longestCommonSubSequenceMemoization.score("ABCDGH", "AEDFHR");
		System.out.println(value);
	}

	private int score(String string, String string2) {
		array = new int[string.length()+1][string2.length()+1];
		for (int i = 0; i <=string.length(); i++) {
			for (int j = 0; j < string2.length(); j++) {
				array[i][j]=-1;
			}
			
		}
		char[] a=string.toCharArray();
		char[] b = string2.toCharArray();
		int value = score(a, b,0,0,array);
		return value;
	}

	private int score(char[] a, char[] b, int i, int j, int[][] array2) {
		
		if(array2[i][j]!=-1){
			return array2[i][j];
		}
		if(i>=a.length || j>=b.length){
			return 0;
		}
	else if(a[i]==b[j]){
			return 1+score(a, b,i+1,j+1,array2);
		}
		else{
			final int x;
			final int y;
			x=score(a, b, i+1, j,array2);
			y=score(a, b, i, j+1,array2);
			array2[i][j]=max(x, y);
			return array2[i][j];
		}
	}

	private int max(int x, int y) {
		
		return x>y?x:y;
	}
	
	}


