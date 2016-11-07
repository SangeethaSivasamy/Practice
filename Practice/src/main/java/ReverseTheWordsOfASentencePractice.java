/**
 * 
 */

/**
 * @author sparida
 *
 */
public class ReverseTheWordsOfASentencePractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseTheWordsOfASentencePractice sentence = new ReverseTheWordsOfASentencePractice();
		String string = sentence.reverseWords("car color is blue");
		System.out.println(string);

	}

	private String reverseWords(String string) {
		if(string==null || string.length()==0){
			return string;
		}
		String[] array = string.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = array.length-1; i>=0; i--) {
			if(!array[i].equals("")){
				sb.append(array[i]).append(" ");
			}
		}
		return sb.toString().length()==0?"":(String) sb.toString().subSequence(0, sb.toString().length()-1);
		
	}

}
