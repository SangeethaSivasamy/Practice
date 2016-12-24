/**
 * 
 */
package com.subrat.Tree;



/**
 * @author sparida
 *
 */
public class UniValTree {
	
	private static TreeNode root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniValTree uniValTree =new UniValTree();
		uniValTree.root=new TreeNode(1);
		uniValTree.root.left=new TreeNode(2);
		uniValTree.root.left.left=new TreeNode(2);
		uniValTree.root.left.right=new TreeNode(2);
		uniValTree.root.left.left.left=new TreeNode(5);
		uniValTree.root.left.left.right=new TreeNode(5);
		uniValTree.root.right=new TreeNode(3);
		uniValTree.root.right.left=new TreeNode(3);
		uniValTree.root.right.right=new TreeNode(3);
		uniValTree.root.right.left.left=new TreeNode(4);
		uniValTree.root.right.left.right=new TreeNode(4);
		uniValTree.root.right.right.left=new TreeNode(3);
		uniValTree.root.right.right.right=new TreeNode(3);
		Integer no =uniValTree.uniqueValueCount(root);
		
		
		

	}
	private Integer uniqueValueCount(TreeNode root) {
		int counter=0;
		uniqueValueCount(root,counter);
		return counter;
		
		
	}
	private void uniqueValueCount(TreeNode root, int counter) {
		
		if(root==null){
			return;
		}
		
		if(isUnique(root)){
			counter++;
		}else{
			uniqueValueCount(root.left,counter);
			uniqueValueCount(root.right, counter);
		}
		
		
	}
	private boolean isUnique(TreeNode root) {
		if(root==null){
			return true;
		}
		int key = root.data;
		return isUniqueUtil(root,key);
	
	}
	
	private boolean isUniqueUtil(TreeNode root, int key) {
		if(root==null){
			return true;
		}
		return root.data==key && isUniqueUtil(root.left, key) && isUniqueUtil(root.right, key);
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
