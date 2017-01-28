/**
 * 
 */
package com.subrat.recursion;

import java.util.List;

/**
 * @author sparida
 *
 *http://stackoverflow.com/questions/728972/finding-all-the-subsets-of-a-set
 *
 */
public class SubSetsOfASet_2nd_Way {
	
	
	List<List<Integer> > getSubsets(List<Integer> a){


		//base case
		    //if there is just one item then its subsets are that item and empty item
		    //for example all subsets of {1} are {1}, {}

		    if(a.size() == 1){
		    	List<List<Integer> > temp;
		        temp.add(a);

		        List<Integer> b;
		        temp.add(b);

		        return temp;

		    }
		    else
		    {


		         //here is what i am doing

		         // getSubsets({1, 2, 3})
		         //without = getSubsets({1, 2})
		         //without = {1}, {2}, {}, {1, 2}

		         //with = {1, 3}, {2, 3}, {3}, {1, 2, 3}

		         //total = {{1}, {2}, {}, {1, 2}, {1, 3}, {2, 3}, {3}, {1, 2, 3}}

		         //return total

		        int last = a[a.size() - 1];

		        a.pop_back();

		        List<List<Integer> > without = getSubsets(a);

		        List<List<Integer> > with = without;

		        for(int i=0;i<without.size();i++){

		            with[i].push_back(last);

		        }

		        vector<vector<int> > total;

		        for(int j=0;j<without.size();j++){
		            total.push_back(without[j]);
		        }

		        for(int k=0;k<with.size();k++){
		            total.push_back(with[k]);
		        }


		        return total;
		    }


		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
