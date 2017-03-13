/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 * 
 * Symmetric Tree (Mirror Image of itself) Given a binary tree, check whether it is a mirror of itself. For example, this binary tree is symmetric: 1 / \ 2 2 / \ / \ 3 4 4 3.
 *
 */
public class SymmetricTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (rightNode == null && leftNode == null)
            return true;
        if (rightNode == null)
            return false;
        if (leftNode == null)
            return false;

        
        return leftNode.val == rightNode.val
                && isSymmetric(leftNode.left, rightNode.right)
                && isSymmetric(leftNode.right, rightNode.left);

    }
}