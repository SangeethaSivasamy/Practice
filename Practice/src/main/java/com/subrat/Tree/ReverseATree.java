/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class ReverseATree {
	
	private static TreeNode root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseATree reverseATree = new ReverseATree();
		reverseATree.root=new TreeNode(6);
		reverseATree.root.left=new TreeNode(3);
		reverseATree.root.right=new TreeNode(4);
		reverseATree.root.left.left=new TreeNode(7);
		reverseATree.root.left.right=new TreeNode(3);
		reverseATree.root.right.left=new TreeNode(8);
		reverseATree.root.right.right=new TreeNode(1);
		preOrderTraversal(root);
		System.out.println();
		reverseATree.reverseATreeFromLeftToRight(root);
		preOrderTraversal(root);
	}
	
	private static void preOrderTraversal(TreeNode root) {
		if(root==null){
			return;
		}
		
		System.out.print(root.data);
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}

	private void reverseATreeFromLeftToRight(TreeNode root) {
		
		if(root==null){
			return;
		}
		
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		
		reverseATreeFromLeftToRight(root.left);
		reverseATreeFromLeftToRight(root.right);
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
