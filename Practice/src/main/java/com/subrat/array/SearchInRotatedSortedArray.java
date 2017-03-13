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
