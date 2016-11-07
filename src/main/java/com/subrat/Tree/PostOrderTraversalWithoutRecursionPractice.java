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
public class PostOrderTraversalWithoutRecursionPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PostOrderTraversalWithoutRecursionPractice postOrderTraversalWithoutRecursionPractice = new PostOrderTraversalWithoutRecursionPractice();
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
		//List<Integer> list = postOrderTraversalWithoutRecursionPractice.postOrderTraversal(root);
		List<Integer> list = postOrderTraversalWithoutRecursionPractice.postOrderTraversal_2ndWay(root);
		for (Integer integer : list) {
			System.out.print(integer+",");
		}
	}
	
	private List<Integer> postOrderTraversal_2ndWay(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		if(root==null){
			return list;
		}
		Stack<TreeNode> s = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
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

	private List<Integer> postOrderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode temp = stack.peek();
			if(temp.left==null && temp.right==null){
				TreeNode p = stack.pop();
				list.add(p.value);
			}else{
				if(temp.getRight()!=null){
					stack.push(temp.right);
					temp.right=null;
				}
				if(temp.left!=null){
					stack.push(temp.left);
					temp.left=null;
				}
			}
		}
		return list;
	}
	
	static void createBalancedBST(int[] iArray) {
		int length = iArray.length;
		int mid = length/2;
		int value = iArray[mid];
		int start=0;
		int end = length-1;
		TreeNode root = new TreeNode(value);
		TreeNode treeNode = createBinarySearchTree(root,iArray,start,end);
		

    }

	
	private static TreeNode createBinarySearchTree(TreeNode root, int[] iArray, int start, int end) {
		int mid = start+(end-start)/2;
		while(start<=end){
			root.left = createBinarySearchTree(root.left, iArray, 0, mid-1);
			root.right = createBinarySearchTree(root.right, iArray, mid+1, end);
		}
		return root;
		
	}
	
	private static List<Integer> inOrderTraversal(TreeNode root){
		List<Integer> list = new ArrayList<>();
		if(root==null){
			return list;
		}
		
		inOrderTraversal(root.left);
		list.add(root.value);
		inOrderTraversal(root.right);
		
		return list;
		
	}
	
	private Integer height(TreeNode root){
		if(root==null){
			return 0;
		}
		else{
			return height(root.left)>height(root.right)?height(root.left)+1:height(root.right)+1;
		}
	
		
	}
	
	
	public static void main(String[] args) {
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
		List<Integer> list = inOrderTraversal(root);
		Object[] array = list.toArray();
		for (Object object : array) {
			System.out.println(object.toString());
		}
	}

	private static class TreeNode{
		Integer value;
		TreeNode left;
		TreeNode right;
		
		TreeNode(Integer value){
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
