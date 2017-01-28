/**
 * 
 */
package com.subrat.heaps;

import java.util.PriorityQueue;

/**
 * K largest element in an array
 */
public class kLargestElement {

    public static int findKthLargest(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++){
            heap.offer(arr[i]);
            if (heap.size() > k){
                heap.poll();
            }
        }

        return heap.peek();
    }

    public static void main(String[] args) {
        int result = findKthLargest(new int[]{3,1,2,5,6,4}, 3);
        System.out.println(result);
    }
}
