/**
 * 
 */
package com.subrat.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sparida
 *
 */
public class ZipTwoListsPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list1= Arrays.asList(1,2,3);
		List<Integer> list2 =Arrays.asList(4,5,6);
		ZipTwoListsPractice zipTwoListsPractice = new ZipTwoListsPractice();
		List<List<Integer>> list =zipTwoListsPractice.zip(list1,list2);
		System.out.println(list);
	}

	private <T> List<List<T>> zip(List<T>...lists) {
		List<List<T>> zipped = new ArrayList<List<T>>();
		for (List<T> list : lists) {
			for (int i = 0,listSize=list.size(); i < listSize; i++) {
				List<T> list2=null;
				if(i>=zipped.size()){
					zipped.add(list2=new ArrayList<>());
				}else{
					list2=zipped.get(i);
				}
				list2.add(list.get(i));
			}
		}
		return zipped;
		
		
	}

}
