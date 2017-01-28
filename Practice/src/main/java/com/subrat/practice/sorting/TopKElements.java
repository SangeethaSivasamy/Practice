/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sparida
 *
 */
public class TopKElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = {4, 3, 2, 6,13,9};
		TopKElements topKElements = new TopKElements();
		PriorityQueue<Integer> result =topKElements.findKLargestElements(array,3);
		while(!result.isEmpty()){
			System.out.print(result.poll()+",");
		}

	}

	private PriorityQueue<Integer> findKLargestElements(int[] array,int k) {
		if(array==null || array.length==0){
			return null;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				return o1-o2;
			}
		});
		
		for (int i = 0; i < k; i++) {
			pq.add(array[i]);
		}
		
		for (int i = k; i < array.length; i++) {
			if(pq.peek()<array[i]){
				pq.remove(pq.peek());
				pq.add(array[i]);
			}
		}
		
		return pq;
	}

}
