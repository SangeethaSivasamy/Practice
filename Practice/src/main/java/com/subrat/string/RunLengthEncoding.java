package com.subrat.string;

/**
 * Run Length encoding
 * eg. aaaabcccaa -> 4a1b3c2a
 */
public class RunLengthEncoding {
	
	/*
	 * Traverse the source string Append current char to result first Get count
	 * with a loop, note the edge case Append count of current char to result
	 */
	public static String encoding(String src) {
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

    /*public static String encoding(String input){
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= input.length(); ++i){
            if (i == input.length() || input.charAt(i) != input.charAt(i-1)){
                sb.append(count);
                sb.append(input.charAt(i-1));
                count = 1;
            } else if (input.charAt(i) == input.charAt(i-1)){
                ++count;
            }
        }
        return sb.toString();
    }*/


    public static String decoding(String input){

        int count = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);

            if(Character.isDigit(ch)){
                count = count * 10 + ch - '0';
            } else {
                while (count > 0){
                    sb.append(ch);
                    count--;
                }
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String str = new String("aaabcccaa");
        String encoded = encoding(str);
        System.out.println("Encoded:: " + encoded);
        String decoded = decoding(encoded);        
        System.out.println("Decoded:: " + decoded);
    }


}