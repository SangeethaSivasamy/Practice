/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 *
 */
public class ReverseAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseAString reverseAString = new ReverseAString();
		String result = reverseAString.reverse("subrat");
		System.out.println(result);

	}

	private String reverse(String string) {
		int start = 0;
		int end = string.length()-1;
		char[] array = string.toCharArray();
		while(start<end){
			char temp = array[start];
			array[start]=array[end];
			array[end]=temp;
			start++;
			end--;
			//StringBuilder sb = new StringBuilder(string);
			//String result = sb.reverse().toString();
		}
		return new String(array);
	}

}
