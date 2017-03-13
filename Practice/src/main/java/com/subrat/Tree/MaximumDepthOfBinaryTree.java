/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 * /**
 * Given a binary tree, find its maximum depth. </br>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 */
public class MaximumDepthOfBinaryTree {
	
	public int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int iRightDepth = maxDepth(root.right);
        int iLefttDepth = maxDepth(root.left);
        return (iRightDepth > iLefttDepth) ? iRightDepth + 1 : iLefttDepth + 1;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
