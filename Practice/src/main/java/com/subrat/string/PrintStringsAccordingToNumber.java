package com.subrat.string;


/*If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate. Give a count as well as print the strings. 

For example: 
Input: "1123". You need to general all valid alphabet codes from this string. 

Output List 
aabc //a = 1, a = 1, b = 2, c = 3 
kbc // since k is 11, b = 2, c= 3 
alc // a = 1, l = 12, c = 3 
aaw // a= 1, a =1, w= 23 
kw // k = 11, w = 23
*/
public class PrintStringsAccordingToNumber {
	static String alphabet = "#abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {

		parseNumber(0, 3, "1123", "");
		//interpretations("1123");

	}

	private static void parseNumber(int i, int j, String string, String result) {
		if (j < i) {
			System.out.println(result);
			return;
		}

		int c = Integer.parseInt(string.charAt(j) + "");
		if (c <= 26)
			parseNumber(i, j - 1, string, alphabet.charAt(c) + result);

		if (j > 0) {
			c = Integer.parseInt(string.charAt(j - 1) + "" + string.charAt(j) + "");
			if (c <= 26)
				parseNumber(i, j - 2, string, alphabet.charAt(c) + result);
		}

	}
	
	
	private static int interpretations(String str)
	{
		int index = str.length() - 1;
		int count = 1;
		int prevCount = 1, prevPrevCount = 1;
		for (int i=index; i>=0; --i)
		{
			if (i < index)
			{
				int number = str.charAt(i + 1) - '0' + (str.charAt(i) - '0') * 10;
				if (number <= 26)
				{
					count += prevPrevCount;
				}
			}
			prevPrevCount = prevCount;
			prevCount = count;
		}
		return count;
	}
}
