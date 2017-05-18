/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 *
 */
public class ReverseWordsInaString {
	
	private static String input = "This is a String";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseWordsInaString reverseWordsInaString = new ReverseWordsInaString();
		reverseWordsInaString.reverse(input.toCharArray());
		//System.out.println(input.toCharArray());
	}

	private void reverse(char[] array) {
		int j=0;
		for (int i = 0; i < array.length; i++) {
			if(array[i]==' ' && i>0){
				reverse(array,j,i-1);
				j=i+1;
			}
			else if(i==array.length-1){
				reverse(array,j,i);
			}
		}
		
		reverse(array, 0, array.length-1);
		System.out.println(array);
		
	}

	private void reverse(char[] array, int j, int i) {
		while(j<i){
			swap(array,j,i);
			j++;
			i--;
		}
		
	}

	private void swap(char[] array, int j, int i) {
		char temp = array[j];
		array[j]=array[i];
		array[i]=temp;
		
	}

}
