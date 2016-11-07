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
public class PreOrderTraversalWithoutRecursion {
	
	
	
	public List<Integer> preOrderTraversal(TreeNode root){
		
		List<Integer> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		
		if(root==null){
			return list;
		}
		stack.push(root);
		while(!stack.isEmpty()){
			TreeNode data = stack.pop();
			list.add(data.getData());
			
			if(data.getRightChild()!=null){
				stack.push(data.getRightChild());
			}
			
			if(data.getLeftChild()!=null){
				stack.push(data.getLeftChild());
			}
			
			
		}
		
		return list;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PreOrderTraversalWithoutRecursion preOrderTraversal = new PreOrderTraversalWithoutRecursion();
		TreeNode root = new TreeNode(2);
		TreeNode left = new TreeNode(1);
		TreeNode right = new TreeNode(3);
		root.setLeftChild(left);
		root.setRightChild(right);
		List<Integer> list =preOrderTraversal.preOrderTraversal(root);
		for (Integer integer : list) {
			System.out.print(integer);
		}
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
		
		public TreeNode find(int data){

	        if(data==this.data){
	            return this;
	        }
	        if(data<this.data && leftChild !=null){
	            return leftChild.find(data);
	        }
	        if(data>this.data && rightChild!=null){
	            return rightChild.find(data);
	        }
	        return null;

	    }

	    public void insert(Integer data){
	        if(data>= this.data){
	            if(this.rightChild == null){
	                this.rightChild = new TreeNode(data);
	            }else{
	                this.rightChild.insert(data);
	            }
	        }else{
	            if(this.leftChild == null){
	                this.leftChild = new TreeNode(data);
	            }else{
	                this.leftChild.insert(data);
	            }

	        }
	    }
	    
	}

}
