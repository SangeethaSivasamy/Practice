/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 *
 */
public class SearchInRotatedSortedArray {
	
	private static int array[] = {3,5,7,8,9,10,0,1,2};
	
	
	private int searchInRotatedSortedArray(int[] A,int n, int target){
		int low=0;
		int high=n-1;
		while(low<= high){
			int mid=low+(high-low)/2;
			if(target==A[mid]) return mid; //case 1
			if(A[mid] <=A[high]){ //case 2 right half is sorted
				if(target>A[mid] && target <=A[high]){
					low=mid+1;
				}else{
					high=mid-1;
				}
			}else{ //case 3 left half is sorted
				if(A[low] <=target && target < A[mid]){
					high=mid-1;
				}else{
					low=mid+1;
				}
			}
		}
		return -1;
	}
	
	
	public int search(int[] A, int target) {
	    int lo = 0;
	    int hi = A.length - 1;
	    while (lo < hi) {
	        int mid = (lo + hi) / 2;
	        if (A[mid] == target) return mid;
	        
	        if (A[lo] <= A[mid]) {
	            if (target >= A[lo] && target < A[mid]) {
	                hi = mid - 1;
	            } else {
	                lo = mid + 1;
	            }
	        } else {
	            if (target > A[mid] && target <= A[hi]) {
	                lo = mid + 1;
	            } else {
	                hi = mid - 1;
	            }
	        }
	    }
	    return A[lo] == target ? lo : -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
		Integer data = searchInRotatedSortedArray.search(array, 1);
		System.out.println(data);
	}

}
