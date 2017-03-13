/**
 * 
 */
package com.subrat.practice.sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author sparida
 *
 */
public class ThreeSumProblem {

	public List<List<Integer>> threeSum(int[] num) {
		Arrays.sort(num);
		LinkedList<List<Integer>> ret = new LinkedList<>();
		HashSet<List<Integer>> set = new HashSet<>();
		for (int i = 0; i < num.length - 2; i++) {
			int start = i + 1;
			int end = num.length - 1;
			while (start < end) {
				if (num[i] + num[start] + num[end] == 0) {
					LinkedList<Integer> oneResult = new LinkedList<>();
					oneResult.add(num[i]);
					oneResult.add(num[start]);
					oneResult.add(num[end]);
					set.add(oneResult);
					start++;
					end--;
				} else {
					if (num[i] + num[start] + num[end] < 0)
						start++;
					else
						end--;
				}
			}
		}
		ret.addAll(set);
		return ret;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[] { -1, 0, 1, 2, -1, -4 };
		//int[] array = new int[] {-2,-1,0,1,2};
		ThreeSumProblem threeSumProblem = new ThreeSumProblem();
		List<List<Integer>> listOfList = threeSumProblem.threeSum(array);
		for (int i = 0; i < listOfList.size(); i++) {
			for (Integer list : listOfList.get(i)) {
				System.out.print(list+",");
			}
			System.out.println();
		}

	}

}
