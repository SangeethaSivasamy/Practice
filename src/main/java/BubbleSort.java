import java.util.Arrays;

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class BubbleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[]{5,3,9,7,1,8};
		bubbleSort(array);

	}

	private static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 1; j < array.length-i; j++) {
				if(array[j-1] > array[j]){
					int temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(array));
		
	}

}
