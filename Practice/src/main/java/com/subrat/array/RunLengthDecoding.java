/**
 * 
 */
package com.subrat.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sparida
 *
 */
public class RunLengthDecoding {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RunLengthDecoding runLengthDecoding = new RunLengthDecoding();
		String result = runLengthDecoding.decode("4w3a20x");
		System.out.println(result);

	}

	private String decode(String string) {
		StringBuffer dest = new StringBuffer();
        Pattern pattern = Pattern.compile("[0-9]+|[a-zA-Z]");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            matcher.find();
            while (number-- != 0) {
                dest.append(matcher.group());
            }
        }
        return dest.toString();
	
	}

}
