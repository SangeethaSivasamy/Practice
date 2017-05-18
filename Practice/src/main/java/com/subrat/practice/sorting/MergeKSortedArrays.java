/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author sparida
 *
 *
 *http://www.byte-by-byte.com/mergekarrays/
 */
public class MergeKSortedArrays {

	public static int[] merge(int[][] arrays) {
	    PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
	 
	    int size = 0;
	    for (int i = 0; i < arrays.length; i++) {
	        size += arrays[i].length;
	        if (arrays[i].length > 0) {
	            pq.add(new QueueNode(i, 0, arrays[i][0]));
	        }
	    }
	 
	    int[] result = new int[size];
	    for (int i = 0; !pq.isEmpty(); i++) {
	        QueueNode n = pq.poll();
	        result[i] = n.value;
	        int newIndex = n.index + 1;
	        if (newIndex < arrays[n.array].length) {
	            pq.add(new QueueNode(n.array, newIndex, 
	            arrays[n.array][newIndex]));
	        }
	    }
	 
	    return result;
	}
 
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = merge(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
}

class QueueNode implements Comparable<QueueNode> {
    int array, index, value;
 
 
    public QueueNode(int array, int index, int value) {
        this.array = array;
        this.index = index;
        this.value = value;
    }
 
    public int compareTo(QueueNode n) {
        if (value > n.value) return 1;
        if (value < n.value) return -1;
        return 0;
    }
}