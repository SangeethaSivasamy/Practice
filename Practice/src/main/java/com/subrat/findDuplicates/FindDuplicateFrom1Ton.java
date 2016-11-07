/**
 * 
 */
package com.subrat.findDuplicates;

/**
 * @author sparida
 *
 */
public class FindDuplicateFrom1Ton {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{1,2,4,3,2,6,2};
		FindDuplicateFrom1Ton duplicate = new FindDuplicateFrom1Ton();
		duplicate.find(array);

	}

	private void find(int[] array) {
		int index = 0;
		
		while(true){
			int element = array[index];
			if(array[element] == element){
				System.out.println("Duplicate element :"+element+" found");
				break;
			}else{
				int temp = array[index];
				array[index] = array[element];
				array[element] = temp;
			}
		}
		
	}

}
