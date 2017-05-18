/**
 * 
 */
package com.subrat.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sparida
 *
 */
public class InvertBinaryTree {
	
	private TreeNode root;
	
	 static class TreeNode{
		int data;
		TreeNode left;
		TreeNode right;
		public TreeNode(int data) {
			this.data=data;
		}
	}

public TreeNode invertTree(TreeNode root) {
        
        if (root == null) {
            return null;
        }

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            final TreeNode node = queue.poll();
            final TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }
	public static void main(String[] args) {
		

	}
	
	
}
