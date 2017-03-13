package com.subrat.Tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * @author sparida
 *
 */

public class SameTree {
	
	private Boolean isSame(TreeNode p, TreeNode q){
		if(p==null || q==null){
			return true;
		}
		if((p==null && q!=null)  || (p!=null && q==null) || (p.data!=q.data)){
			return false;
		}
		return isSame(p.left, q.left) && isSame(p.right, q.right);
	}
	private class TreeNode{
		Integer data;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(Integer data){
			this.data=data;
		}
	}
}
