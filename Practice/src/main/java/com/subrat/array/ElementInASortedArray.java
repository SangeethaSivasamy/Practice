/**
 * 
 */
package com.subrat.array;

/**
 * @author sparida
 * 
 * suppose you have a sorted array of infinite numbers, how
   would you search an element in the array?

Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position of key, first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.


Time Complexity : O(log n), where n is the position of element in the array.
 *
 */
public class ElementInASortedArray {
	
	// Simple binary search algorithm
	static int binarySearch(int arr[], int l, int r, int x)
	{
	    if (r>=l)
	    {
	        int mid = l + (r - l)/2;
	        if (arr[mid] == x)
	            return mid;
	        if (arr[mid] > x)
	            return binarySearch(arr, l, mid-1, x);
	        return binarySearch(arr, mid+1, r, x);
	    }
	    return -1;
	}
	 
	// function takes an infinite size array and a key to be
	//  searched and returns its position if found else -1.
	// We don't know size of arr[] and we can assume size to be 
	// infinite in this function.
	static int findPos(int arr[], int key)
	{
	    int l = 0, h = 1;
	    int val = arr[0];
	 
	    // Find h to do binary search
	    while (val < key)
	    {
	        l = h;        // store previous high
	        h = 2*h;      // double high index
	        val = arr[h]; // update new val
	    }
	 
	    // at this point we have updated low and high indices,
	    // thus use binary search between them
	    return binarySearch(arr, l, h, key);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 
		int arr[] = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
	    int ans = findPos(arr, 10);
	    if (ans==-1)
	        System.out.println("Element not found");
	    else
	    	System.out.println("Element found at index :"+ans);
	}

}
