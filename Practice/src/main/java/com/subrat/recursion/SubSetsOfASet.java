/**
 * 
 */
package com.subrat.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sparida
 *
 */
public class SubSetsOfASet {
	
	String str = "abcd"; 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubSetsOfASet subSetsOfASet = new SubSetsOfASet();
		int[] array = new int[]{1,2,3,4};
		List<List<Integer>> result =subSetsOfASet.subsets(array);
        /*for(int i = 0; i< subSetsOfASet.str.length();i++){ //traverse through all characters
        	subSetsOfASet.subs("",i);
        }*/

	}
	
	void subs(String substr,int index)
    {
        String s = ""+str.charAt(index); //very important, create a variable on each stack
        s = substr+s; //append the subset so far
        System.out.println(s); //print

        for(int i=index+1;i<str.length();i++)
          subs(s,i); //call recursively

    }
	
	public List<List<Integer>> subsets(int[] S) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	   
	    if(S.length == 0){
	        return result;
	    }
	    
	    Arrays.sort(S);
	    dfs(S, 0, new ArrayList<Integer>(), result);
	    return result;
	}

	public void dfs(int[] s, int index, List<Integer> path, List<List<Integer>> result){
	    result.add(new ArrayList<Integer>(path));
	    
	    for(int i = index; i < s.length; i++){
	        path.add(s[i]);
	        dfs(s, i+1, path, result);
	        path.remove(path.size()-1);
	    }
	}

}
