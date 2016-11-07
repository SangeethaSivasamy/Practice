/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class isBST {
	
	static boolean isBST(TreeNode root) {
		
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		boolean flag = isBST(root,min,max);
		
		return flag;


    }

	private static boolean isBST(TreeNode root, int min, int max) {
		if(root==null){
			return true;
		}
		if (min < root.getData() && root.getData() < max) {
			return isBST(root.getLeftChild(),min,root.getData()) &&
					isBST(root.getRightChild(),root.getData(),max);
		}
		return false;
	}

}
