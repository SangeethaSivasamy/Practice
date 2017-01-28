/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class ZeroSumSubArrays {
	
	Map<Integer,Integer> map = new HashMap<>();
	List<ArrayList<int[]>> list = new ArrayList<ArrayList<int[]>>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {5, 1, 2, -3, 7, -4};
		ZeroSumSubArrays zeroSumSubArrays = new ZeroSumSubArrays();
		List<ArrayList<int[]>> list = zeroSumSubArrays.findAllTheArrays(arr);
		for (ArrayList<int[]> arrayList : list) {
			for(int[] data : arrayList)
				System.out.println(Arrays.toString(data));
		}

	}

	private List<ArrayList<int[]>> findAllTheArrays(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			Integer oldIndex = map.get(i);
			if(oldIndex==null){
				map.put(sum, i);
				sum+=arr[i];
			}else{
				
				list.add((ArrayList<int[]>) Arrays.asList(Arrays.copyOfRange(arr, oldIndex, i)));
			}
		}
		return list;
	}

}
