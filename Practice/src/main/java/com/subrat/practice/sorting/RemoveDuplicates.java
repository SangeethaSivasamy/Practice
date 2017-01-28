/**
 * 
 */
package com.subrat.practice.sorting;

/**
 * @author sparida
 *
 */
public class RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
        
        int length = nums.length;
        int count = 0;
        if(length >= 2){
        	for(int i = length -1 ;i>=0; i--){
	            
	            if((i -1) >=0){
	                    if(nums[i] == nums[i-1]){
	                        shiftHelper(nums,i);
	                        count++;
	                    }
	            }
	        }
	      
        }
   
        
        return length - count;
        
    }

private void shiftHelper(int[] arr,int pos){
    
    for(int i = pos; i< arr.length; i++){
        if((i+1) < arr.length){
            arr[i] = arr[i+1];
        }
    }
}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{1,2,2,3,3,3,4,4};
		RemoveDuplicates removeDuplicates = new RemoveDuplicates();
		Integer no = removeDuplicates.removeDuplicates(array);
		System.out.println();

	}

}
