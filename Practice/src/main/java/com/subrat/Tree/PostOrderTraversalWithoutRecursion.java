/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sparida
 *
 */
public class PostOrderTraversalWithoutRecursion {

	/**
	 * @param args
	 * so, it will be traversing left child, right child and then the root node
	 * idea is if the left child and right child of a node is null, then put that in the list, otherwise, put the right child of that node in stack and then put the left child
	 * of that node in the stack
	 * 
	 */
	public static void main(String[] args) {
		
		PostOrderTraversalWithoutRecursion postOrderTraversalWithoutRecursion = new PostOrderTraversalWithoutRecursion();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		TreeNode leftofleft = new TreeNode(4);
		TreeNode rightofleft = new TreeNode(5);
		root.setLeftChild(left);
		root.setRightChild(right);
		left.setLeftChild(leftofleft);
		left.setRightChild(rightofleft);
		List<Integer> list = postOrderTraversalWithoutRecursion.postOrderTraversal(root);
		for (Integer integer : list) {
			System.out.print(integer);
		}

	}
	
	private List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		if(root==null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.peek();
	        if(temp.leftChild==null && temp.rightChild==null) {
	            TreeNode pop = stack.pop();
	            list.add(pop.data);
	        }
	        else {
	            if(temp.rightChild!=null) {
	                stack.push(temp.rightChild);
	                // below line is assigned to null, otherwise, the while loop will run in a infinite loop and stack will naver be empty
	                temp.rightChild = null;
	            }
	 
	            if(temp.leftChild!=null) {
	                stack.push(temp.leftChild);
	                //below line is assigned to null, otherwise, the while loop will run in a infinite loop and stack will naver be empty
	               temp.leftChild = null;
	            }
	        }
	    }
		return list;
	}

	private static class TreeNode{
		int data;
	    TreeNode leftChild;
	    TreeNode rightChild;
	    
	    TreeNode(int data){
	    	this.data = data;
	    }

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public TreeNode getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode rightChild) {
			this.rightChild = rightChild;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
		}
		
		

}
	
}
