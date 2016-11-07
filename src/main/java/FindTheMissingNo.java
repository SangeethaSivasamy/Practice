/**
 * 
 */

/**
 * @author sparida
 *
 */
public class FindTheMissingNo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{1,2,4,5,6};
		int length = array.length;
		System.out.println(new FindTheMissingNo().findTheMissingNo(array,length));

	}

	private int findTheMissingNo(int[] array, int length) {
		int result = array[0];
		int result1 = 1;
		for (int i = 1; i < length; i++) {
			result = result ^ array[i];
		}
		
		for (int i = 2; i <= length+1; i++) {
		result1 = result1 ^ i;	
		}
		
		
		
		return result^result1;
	}

}
