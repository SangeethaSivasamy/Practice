package com.subrat.Tree;

import java.util.HashMap;
import java.util.Map;

/*
 * http://www.ideserve.co.in/learn/diagonal-sum-of-a-binary-tree
 * As is marked in the tree, root node-0 is placed in diagonal 0, then its left child node-1 is placed in diagonal 1 and 
 * its right child node-2 is placed in the same diagonal as node-0 that is diagonal 0. 
 * This observation can be easily generalized - if current node is placed in diagonal 'd' then its left child would be placed in diagonal 'd+1' 
 * and its right child would be placed in the same diagonal as that of current node that is diagonal 'd'.
 */

public class DiagonalSumTree {
	private class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
     
    TreeNode root;
 
    /*
                             0
                      1              2
                   4      5        3    6
                        7                
    */
    public void createTree()
    {
        this.root = new TreeNode(0);
 
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
 
        root.left  = n1;
        root.right = n2;
         
        n1.left  =  n4;
        n1.right = n5;
         
        n2.left  = n3;
        n2.right = n6;
         
        n5.left = n7;
    }
    private void computeDiagSum(TreeNode currentNode, int currDiag, HashMap<Integer, Integer> diagSum) 
    {
        if (currentNode == null)
        {
            return;
        }
         
        // compute diagonal sum for the tree rooted at the left child
        // left child would be placed in 'currDiag + 1'
        computeDiagSum(currentNode.left, currDiag + 1, diagSum);
         
        // now add current node's value to its diagonal sum 
        int prevSum = (diagSum.get(currDiag) == null) ? 0 : diagSum.get(currDiag) ;
        diagSum.put(currDiag, prevSum + currentNode.value);
 
        // compute diagonal sum for the tree rooted at the right child
        // right child would be placed in the same diagonal as that of current node
        computeDiagSum(currentNode.right, currDiag, diagSum);
    }
    public void computeDiagSum(HashMap<Integer, Integer> diagSum)
    {
        computeDiagSum(root, 0, diagSum);
    }
     
    public static void main(String[] args) 
    {
        DiagonalSumTree solution = new DiagonalSumTree();
 
        /*
                                 0
                          1              2
                       4      5        3    6
                            7                
        */
        solution.createTree();
 
        HashMap<Integer, Integer> diagSum = new HashMap();
 
        // this call populates diagSum HashMap with sum for all diagonals
        solution.computeDiagSum(diagSum);
 
        // print sum for each diagonal
        for (Map.Entry<Integer, Integer> entry : diagSum.entrySet()) 
        {
            System.out.println("Diagonal Sum for level " + entry.getKey() + " :" + entry.getValue());
        }
    }

}
