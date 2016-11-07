/**
 * 
 */
package com.subrat.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author sparida
 *
 */
public class ThreeSumProblem {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = new int[]{-5,-2,-1,7,8,2,3,0,98,34};
		ThreeSumProblem threeSumProblem = new ThreeSumProblem();
		List<List<Integer>> list =threeSumProblem.threeSum(array);
		for (List<Integer> list2 : list) {
			for (Integer integer : list2) {
				System.out.print(integer);
				System.out.println(",");
			}
			System.out.println("");
		}

	}
	public List<List<Integer>> threeSum(int[] nums) {
	        List<List<Integer>> result = new ArrayList<List<Integer>>();
	     
	        if(nums == null || nums.length<3)
	            return result;
	     
	        Arrays.sort(nums);
	     
	        for(int i=0; i<nums.length-2; i++){
	            if(i==0 || nums[i] > nums[i-1]){
	                int j=i+1;
	                int k=nums.length-1;
	     
	                while(j<k){
	                    if(nums[i]+nums[j]+nums[k]==0){
	                        List<Integer> l = new ArrayList<Integer>();
	                        l.add(nums[i]);
	                        l.add(nums[j]);
	                        l.add(nums[k]);
	                        result.add(l);
	     
	                        j++;
	                        k--;
	     
	                        //handle duplicate here
	                        while(j<k && nums[j]==nums[j-1])
	                            j++;
	                        while(j<k && nums[k]==nums[k+1])
	                            k--;
	     
	                    }else if(nums[i]+nums[j]+nums[k]<0){
	                        j++;
	                    }else{
	                        k--;
	                    }
	                }
	            }
	     
	        }
	     
	        return result;
	    }
}
