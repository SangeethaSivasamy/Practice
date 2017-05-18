/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class HowManyTimesSortedArrayRotated {
	
	
	private Integer rotationCount(int[] array, int n){ //n is size of array
		
		int low=0;
		int high=n-1;
		while(low<=high){
			if(array[low]<=array[high]) return low; //case 1
			int mid=low+high/2;
			int next=(mid+1)%n;
			int pre=(mid+n-1)%n;
			if(array[mid] <= array[next]  && array[mid]<=array[pre]){
				return mid; //case 2
			}
			else if(array[mid] <= array[high]) high=mid-1; //case 3
			else if(array[mid] >= array[low])  low=mid+1; //case 4
		}
		return -1;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
