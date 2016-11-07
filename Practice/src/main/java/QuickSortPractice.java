import java.util.Arrays;

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class QuickSortPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = new int[]{7,1,9,2,6,9,1,2,6,9,8,1};
		if(array == null || array.length == 0){
			return;
		}
		quickSort(array,0, array.length-1);

	}

	private static void quickSort(int[] array, int start, int end) {
		int i = 0;
		int j = array.length -1;
		int pivot = array[start+(end-start)/2];
		while(i<=j){
			while(array[i]<array[pivot]){
				i++;
			}
			while(array[j]>array[pivot]){
				j--;
			}
			if(i<=j){
				exchange(i,j,array);
				i++;
				j--;
			}
			
		}
		if(start<j){
			quickSort(array,start,j);
		}
		if(i<end){
			quickSort(array, i, end);
			
		}
		
		System.out.println(Arrays.toString(array));
		
	}

	private static void exchange(int i, int j, int[] array) {
		int temp = array[i];
		array[i]=array[j];
		array[j]=temp;
		
	}

}
