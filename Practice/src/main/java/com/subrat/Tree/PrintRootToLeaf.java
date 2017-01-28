/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author sparida
 * 
 *      6
     /    \
    3      5
  /   \     \
 2     5     4
     /   \
    7     4

There are 4 leaves, hence 4 root to leaf paths -
  6->3->2              
  6->3->5->7
  6->3->5->4
  6->5>4
 *
 */
public class PrintRootToLeaf {
	
	private static TreeNode root;
	private static List<Integer> list = new ArrayList<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintRootToLeaf printRootToLeaf = new PrintRootToLeaf();
		printRootToLeaf.root = new TreeNode(1);
		printRootToLeaf.root.left=new TreeNode(2);
		printRootToLeaf.root.right=new TreeNode(3);
		printRootToLeaf.root.left.left=new TreeNode(4);
		printRootToLeaf.root.left.right=new TreeNode(5);
		printRootToLeaf.printAllPathRecursion(root,list);
		printRootToLeaf.printAllPathWithoutRecursion(root);

	}
	
	private void printAllPathRecursion(TreeNode root, List<Integer> list) {
		
		if(root==null){
			return;
		}
		
		list.add(root.data);
		if(root.left==null && root.right==null){
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println();
		}else{
			printAllPathRecursion(root.left, list);
			list.remove(list.size()-1);
			printAllPathRecursion(root.right, list);
			list.remove(list.size()-1);
		}
		
		
	}
	
	private void printAllPathWithoutRecursion(TreeNode root){
		if(root==null){
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		Map<TreeNode, TreeNode> parent = new HashMap<>();
		parent.put(root, null);
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			if(temp.left==null && temp.right==null){
				printTopToBottom(temp,parent);
			}
			if(temp.right!=null){
				stack.push(temp.right);
				parent.put(temp.right, temp);
			}
			if(temp.left!=null){
				stack.push(temp.left);
				parent.put(temp.left, temp);
			}
		}
	}

	private void printTopToBottom(TreeNode temp, Map<TreeNode, TreeNode> parent) {
		
		Stack<TreeNode> stack = new Stack<>();
		while(temp!=null){
			stack.push(temp);
			temp=parent.get(temp);
		}
		
		while(!stack.isEmpty()){
			System.out.print(stack.pop().data);
		}
		System.out.println();
	}

	private static class TreeNode{
		private Integer data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(Integer data){
			this.data=data;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
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
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}

}
