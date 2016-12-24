/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sparida
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
		printRootToLeaf.printAllPath(root,list);

	}
	
	private void printAllPath(TreeNode root, List<Integer> list) {
		
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
			printAllPath(root.left, list);
			list.remove(list.size()-1);
			printAllPath(root.right, list);
			list.remove(list.size()-1);
		}
		
		
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
