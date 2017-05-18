/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;

/**
 * @author sparida
 * 
 * Given two arrays which would be used to construct two different binary search trees(BSTs), write a prgram to identify if the BSTs constructed 
 * from these would be identical. The condition is that the program should be able to identify this without actually building BSTs.
 *
 */
public class CheckIdenticalBSTs {
	
	boolean checkIfSameBSTs(ArrayList<Integer> listForTree1, ArrayList<Integer> listForTree2)
    {
        // both trees should have same size
        if (listForTree1.size() != listForTree2.size())
        {
            return false;
        }
         
        // if both trees are null trees
        if (listForTree1.size() == 0)
        {
            return true;
        }
         
        // root node has to be the same
        if (listForTree1.get(0) == listForTree2.get(0))
        {
            // segregate nodes for left and right sub-trees for both trees
            ArrayList<Integer> listForLeftTree1 = new ArrayList();
            ArrayList<Integer> listForRightTree1 = new ArrayList();
             
            ArrayList<Integer> listForLeftTree2 = new ArrayList();
            ArrayList<Integer> listForRightTree2 = new ArrayList();
             
            for (int i = 1; i < listForTree1.size(); i++)
            {
                if (listForTree1.get(i) < listForTree1.get(0))
                {
                    listForLeftTree1.add(listForTree1.get(i));
                }
                else
                {
                    listForRightTree1.add(listForTree1.get(i));
                }
                 
                if (listForTree2.get(i) < listForTree2.get(0))
                {
                    listForLeftTree2.add(listForTree2.get(i));
                }
                else
                {
                    listForRightTree2.add(listForTree2.get(i));
                }
            }
             
            // and check that left and right sub-tree are also same
            return checkIfSameBSTs(listForLeftTree1, listForLeftTree2) &&
                   checkIfSameBSTs(listForRightTree1, listForRightTree2);
        }
         
        return false;
    }
	boolean checkIfSameBSTs(int[] arrayForTree1, int[] arrayForTree2)
    {
        if (arrayForTree1.length != arrayForTree2.length)
        {
            return false;
        }
         
        ArrayList<Integer> listForTree1 = new ArrayList();
        ArrayList<Integer> listForTree2 = new ArrayList();
         
        for (int i = 0; i < arrayForTree1.length; i++)
        {
            listForTree1.add(arrayForTree1[i]);
            listForTree2.add(arrayForTree2[i]);
        }
        return checkIfSameBSTs(listForTree1, listForTree2);
    }
	

	public static void main(String[] args) 
    {
        CheckIdenticalBSTs solution = new CheckIdenticalBSTs();
         
        int[] arrayForTree1 = {3,5,4,6,1,0,2};
         
        int[] arrayForTree2 = {3,1,5,2,4,6,0};
         
        System.out.println("Check if identical BSTs: " + solution.checkIfSameBSTs(arrayForTree1, arrayForTree2));
    }

}
