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
public class BFSTreeTraversal {
	
	public static void bfs(TreeNode root){
	     Queue<TreeNode> queue = new LinkedList<TreeNode>();
	     queue.add(root);
	     while (!queue.isEmpty()) {
	         TreeNode node = queue.poll();
	         System.out.println(node.val);
	         if (node.left != null) queue.add(node.left);
	         if (node.right != null) queue.add(node.right);
	     }
	}

}
