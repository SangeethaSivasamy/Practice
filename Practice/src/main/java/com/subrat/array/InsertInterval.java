/**
 * 
 */
package com.subrat.array;

import java.util.ArrayList;

/**
 * @author sparida
 * 
 * Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 *
 */
public class InsertInterval {
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		 
        ArrayList<Interval> result = new ArrayList<Interval>();
 
        for(Interval interval: intervals){
            if(interval.high < newInterval.lo){
                result.add(interval);
            }else if(interval.lo > newInterval.high){
                result.add(newInterval);
                newInterval = interval;        
            }else if(interval.high >= newInterval.lo || interval.lo <= newInterval.high){
                newInterval = new Interval(Math.min(interval.lo, newInterval.lo), Math.max(newInterval.high, interval.high));
            }
        }
 
        result.add(newInterval); 
 
        return result;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
