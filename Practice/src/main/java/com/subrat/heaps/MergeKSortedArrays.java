/**
 * 
 */
package com.subrat.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Merge K sorted arrays
 * Solution: use heap
 */
public class MergeKSortedArrays {

    static class QueueNode implements Comparable<QueueNode>{

        int array;
        int index;
        int value;

        public QueueNode(int array, int index, int value) {
            this.array = array;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            if (value > o.value) return 1;
            if (value < o.value) return -1;
            return 0;
        }
    }

    public static int[] merge(int[][] arrays){
        PriorityQueue<QueueNode> heap = new PriorityQueue<>();
        int size = 0;
        for (int i = 0; i < arrays.length; i++){
            size = size + arrays[i].length;
            if (arrays.length > 0){
                heap.add(new QueueNode(i, 0, arrays[i][0]));
            }
        }

        int[] result = new int[size];
        for (int i = 0; !heap.isEmpty(); i++){
            QueueNode q = heap.poll();
            result[i] = q.value;
            int newIndex = q.index + 1;
            if (newIndex < arrays[q.array].length){
                heap.add(new QueueNode(q.array, newIndex, arrays[q.array][newIndex]));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] input = new int[][]{
                        {1,4,7},
                        {2,5,8},
                        {3,6,9}
                        };
        int[] result = merge(input);
        System.out.println(Arrays.toString(result));
    }



}