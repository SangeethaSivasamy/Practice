package com.subrat.Tree;

/*
 * 
 * Write a program to find the sum of all left leaves of a given binary tree
 */



public class SumOfAllLeftLeavesBinaryTree {
	class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;
     
        public TreeNode(int x)
        {
            this.val = x;
        }
    }
     
    TreeNode root;
    /*
    1
2             3
4      5       6     7
8              
9
*/
    private TreeNode createTree()
    {
        TreeNode n1   = new TreeNode(1);
        TreeNode n2   = new TreeNode(2);
        TreeNode n3   = new TreeNode(3);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(5);
        TreeNode n6   = new TreeNode(6);
        TreeNode n7   = new TreeNode(7);
        TreeNode n8   = new TreeNode(8);
        TreeNode n9   = new TreeNode(9);
         
        this.root = n1;
         
        root.left  = n2;
        root.right = n3;
         
        n2.left  = n4;
        n2.right = n5;
         
        n3.left  = n6;
        n3.right = n7;
         
        n4.right = n8;
         
        n8.left = n9;
         
        return root;
    }
    private boolean isLeafNode(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return false;
        }
         
        if (currentNode.left == null && currentNode.right == null)
        {
            return true;
        }
         
        return false;
    }
    public void findLeftLeavesSum(TreeNode currentNode, int[] leftLeavesSum)
    {
        if (currentNode == null)
        {
            return;
        }
        if (isLeafNode(currentNode.left))
        {
            leftLeavesSum[0] += currentNode.left.val;
        }
         
        findLeftLeavesSum(currentNode.left, leftLeavesSum);
        findLeftLeavesSum(currentNode.right, leftLeavesSum);
    }
    public static void main(String[] args)
    {
        SumOfAllLeftLeavesBinaryTree tree = new SumOfAllLeftLeavesBinaryTree();
         
         
        /*
                                1
                          2             3
                      4      5       6     7
                        8              
                      9
        */
        tree.createTree();
         
        int[] leftLeavesSum = new int[1];
        tree.findLeftLeavesSum(tree.root, leftLeavesSum);
         
        System.out.println(leftLeavesSum[0]);
    }
}
