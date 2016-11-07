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
public class PostOrderTraversalUsingTwoStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PostOrderTraversalUsingTwoStack postOrderTraversalUsingTwoStack = new PostOrderTraversalUsingTwoStack();
		TreeNode root = new TreeNode(10);
		TreeNode left = new TreeNode(5);
		TreeNode right = new TreeNode(40);
		TreeNode leftofleft = new TreeNode(1);
		TreeNode rightofleft = new TreeNode(7);
		TreeNode leftofright = new TreeNode(20);
		TreeNode rightofright = new TreeNode(50);
		left.setLeft(leftofleft);
		left.setRight(rightofleft);
		right.setLeft(leftofright);
		right.setRight(rightofright);
		root.setLeft(left);
		root.setRight(right);
		List<Integer> list = postOrderTraversalUsingTwoStack.postOrderTraversal(root);
		for (Integer integer : list) {
			System.out.print(integer+",");
		}

	}
	
	private List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> s = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		if(root==null){
			return list;
		}
		s.push(root);
		while(!s.isEmpty()){
			TreeNode curr = s.peek();
			output.push(curr);
			s.pop();
			if(curr.left!=null){
				s.push(curr.left);
			}
			if(curr.right!=null){
				s.push(curr.right);
			}
			
		}
		
		while(!output.isEmpty()){
			list.add(output.peek().value);
			output.pop();
		}
		return list;
	}

	private static class TreeNode{
		Integer value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(Integer value){
			this.value = value;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}

		public TreeNode getLeft() {
			return left;
		}

		public void setLeft(TreeNode left) {
			this.left = left;
		}

		public TreeNode getRight() {
			return right;
		}

		public void setRight(TreeNode right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "TreeNode [value=" + value + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}

}
