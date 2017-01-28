/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class RunLengthEncoding {

	/*
	 * Traverse the source string Append current char to result first Get count
	 * with a loop, note the edge case Append count of current char to result
	 */
	public String encode(String src) {
		StringBuilder dest = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			//dest.append(src.charAt(i));
			int cnt = 1;
			while (i + 1 < src.length() && src.charAt(i) == src.charAt(i + 1)) {
				i++;
				cnt++;
			}
			if(cnt!=1){
			dest.append(cnt);
			dest.append(src.charAt(i));
			}else{
				dest.append(src.charAt(i));
			}
		}
		return dest.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
		String result = runLengthEncoding.encode("wwwwaaadexxxxxxxxxxxxxxxxxxxx");
		System.out.println(result);
	}

}
