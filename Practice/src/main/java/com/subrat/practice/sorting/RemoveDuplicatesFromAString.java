/**
 * 
 */
package com.subrat.practice.sorting;

/**
 * @author sparida
 *
 */
public class RemoveDuplicatesFromAString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String result = RemoveDuplicatesFromAString.sortCharacters("112233455");
		System.out.println(result);
	}

	private static String sortCharacters(String inString) {
		StringBuilder sb = new StringBuilder();
		if (inString == null || inString.length() < 2) {
			return inString;
		}

		int[] array = new int[256];
		for (char ch : inString.toCharArray()) {
			array[ch]++;

		}

		for (int i = 0; i < 256; i++) {
			if (array[i] == 0)
				continue;
			sb.append((char) i);

		}
		return sb.toString();

	}

}
