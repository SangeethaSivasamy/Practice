/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author sparida
 * 
 * Basically the idea is in the second test case if there are more than one merging intervals, you will need to remove the last element from the result and add a new one.

-----------------------------------------------------
Input: [[8,10], [1,3], [2,6], [15,18]]
sorted list: [[1,3], [2,6], [8,10], [15,18]]
merged interval: [[1,6], [8,10], [15,18]]
-----------------------------------------------------
Input: [[8,10], [1,3], [2,6], [3,9], [15,18]]
sorted list: [[1,3], [2,6], [3,9], [8,10], [15,18]]
merged interval: [[1,10], [15,18]]
 *
 */
public class MergeIntervals {
	
	public static ArrayList<Interval> merge(ArrayList<Interval> list) {
		Collections.sort(list, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2) {
				if (i1.lo == i2.lo) {
					return i1.high - i2.high;
				}
				return i1.lo - i2.lo;
			}
		});
		System.out.println("Sorted Input: " + list);

		ArrayList<Interval> result = new ArrayList<Interval>();
		Interval prev = list.get(0);
                result.add(prev);
		for (int i = 1; i < list.size(); i++) {
			Interval current = list.get(i);
			if (prev.high >= current.lo) {
				Interval interval = new Interval(prev.lo, Math.max(prev.high, current.high));
				prev = interval;
			} else {
				prev = current;
			}
			removeIfExist(result, prev);
			result.add(prev);
		}
		return result;
	}
	
	private static void removeIfExist(ArrayList<Interval> result, Interval prev) {
		if (result.size() > 0) {
			Interval existing = result.get(result.size() - 1);
			if (existing.lo == prev.lo) {
				result.remove(result.size() - 1);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Interval> list = new ArrayList<Interval>();
		list.add(new Interval(8, 10));
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(15, 18));
		System.out.println("Input: " + list);
		System.out.println("merged interval: " + merge(list));
		System.out.println("-----------------------------------------------------");
		list = new ArrayList<Interval>();
		list.add(new Interval(8, 10));
		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(3, 9));
		list.add(new Interval(15, 18));
		System.out.println("Input: " + list);
		System.out.println("merged interval: " + merge(list));
		System.out.println("-----------------------------------------------------");

	}
	
	
	private static class Interval{
		Integer lo;
		Integer high;
		
		public Interval(Integer lo, Integer high){
			this.lo=lo;
			this.high=high;
		}
	}

}
