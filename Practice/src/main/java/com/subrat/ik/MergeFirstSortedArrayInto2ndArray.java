/**
 * 
 */
package com.subrat.ik;

/**
 * @author sparida
 *
 */
public class MergeFirstSortedArrayInto2ndArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] intArrLong = new int[]{1,3,5,7,9,0,0,0,0,0};
		int length = intArrLong.length;
		int[] intArrShort = new int[]{2,4,6,8,10};
		int[] finalArray = MergeFirstSortedArrayInto2ndArray.mergeFirstIntoAnother(intArrShort, intArrLong);
		

	}
	
	static int[] mergeFirstIntoAnother(int[] intArrShort, int[] intArrLong) {
		int intArrLongLength = intArrLong.length;
		int intArrShortLength = intArrShort.length;
		int length = intArrLongLength/2;
		int i = intArrShortLength-1;
		int j = intArrLongLength-1;
		int k = length-1;
		while(length>0 && i>=0){
		if(intArrLong[k] > intArrShort[i]){
			intArrLong[j]=intArrShort[k];
			k--;
			
		}else{
			intArrShort[j] = intArrLong[i];
			i--;
		}
		j--;
		
		}
		
		while(length>0){
			
				intArrLong[j]=intArrShort[k];
				k--;
			}
		
		while(i>=0){
				intArrShort[j] = intArrLong[i];
				i--;
			}
		
		return intArrLong;


    }

}
