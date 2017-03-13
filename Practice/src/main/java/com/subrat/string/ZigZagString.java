/**
 * 
 */
package com.subrat.string;

/**
 * @author sparida
 * 
 * Hint
 * 0    10    20
 * 1   911   1921
 * 2  8 12  18 22
 * 3 7  13 17  23
 * 46   1416   24
 * 5    15     25
 * 
 * if i=0 or i=noRows-1, gap is 2*(numOfRows-1)
 * if 0<i<numRows, gap is 2*(numRows-1-i) and 2i
 * 
 * here in this case numRows=6, so ist and last rows, gap is 2*(6-1)=10 (10-0=20-10=15-5=25-15)
 *
 */
public class ZigZagString {
	
	public static void main(String[] args) {
		ZigZagString zigZagString = new ZigZagString();
		String result = zigZagString.convert("paypalishiring",3);
		System.out.println(result);
	}

	public String convert(String str, int R) {
	    if (R == 1) 
	    	return str;

	    char[] s = str.toCharArray();
	    char[] t = new char[s.length];
	    int len=0;
	    for (int i = 0; i < R; i++) {
	        for (int j = 0, k = i; k < s.length; j++) {
	            t[len++] = s[k];
	            k += ((i == 0 || j % 2 == 0) && i != R - 1 ? 2 * (R - i - 1) : 2 * i);
	        }
	    }

	    return new String(t);
	}
}
