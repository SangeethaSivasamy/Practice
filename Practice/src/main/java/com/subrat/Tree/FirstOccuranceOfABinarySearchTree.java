/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 * 
 * Given a List of sorted numbers and a number 'n'. Find the first occurrence of 'n' in the list of numbers and the number of occurances.
Index starts from 0.

Example: 1, 1, 2, 3, 4, 9, 15 and n is 3. 
Answer: First occurrence of 3 is at Index 3. Number of occurances is 1.

Example: 3, 3 ,3, 3, 3, 12 and n is 3 
Answer: Index is 0. Number of occurances is 5.

Example: 3, 4, 4, 4, 4, 4, 4, 4,1552, 2343 and n is 4. 
Answer: Index is . Number of occurances is 7.

 *
 */
public class FirstOccuranceOfABinarySearchTree {
	
	private static int[] array = new int[]{3,4,4,4,4,4,4,4,1552,2343};

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FirstOccuranceOfABinarySearchTree firstOccuranceOfABinarySearchTree = new FirstOccuranceOfABinarySearchTree();
		int firstOccurance=firstOccuranceOfABinarySearchTree.firstOccurance(array,4);
		int lastOccurance=firstOccuranceOfABinarySearchTree.lasttOccurance(array,4);
		System.out.println(firstOccurance);
		System.out.println(lastOccurance);
		System.out.println("Total Occurance = "+ (lastOccurance-firstOccurance+1));
	}

	private Integer firstOccurance(int[] array,int target) {
		int start=0;
		int end=array.length-1;
		int result = -1;
		while(start<=end){
			int mid=start+(end-start)/2;
			if(array[mid]==target){
				result=mid;
				end=mid-1; //the logic for last occurance of the no is pretty same, just we need to change this line to start=mid+1;;'
			}else if(array[mid]<target){
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
		return result;
		
	}
	
	private Integer lasttOccurance(int[] array,int target) {
		int start=0;
		int end=array.length-1;
		int result = -1;
		while(start<=end){
			int mid=start+(end-start)/2;
			if(array[mid]==target){
				result=mid;
				start=mid+1;
			}else if(array[mid]<target){
				start=mid+1;
			}else{
				end=mid-1;
			}
		}
		return result;
		
	}

}
