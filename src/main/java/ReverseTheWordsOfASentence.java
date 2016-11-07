/**
 * 
 */

/**
 * @author sparida
 *
 */
public class ReverseTheWordsOfASentence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseTheWordsOfASentence sentence = new ReverseTheWordsOfASentence();
		String string = "the sky is blue";
		System.out.println(sentence.reverseWords(string));

	}
	
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		System.out.println(sb.toString());
		System.out.println(sb.length());
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}

}
