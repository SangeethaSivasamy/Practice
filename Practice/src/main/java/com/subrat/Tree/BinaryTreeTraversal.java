/**
 * 
 */
package com.subrat.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * @author sparida
 *
 */
public class BinaryTreeTraversal {
	
	private Tree rootNode;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new BinaryTreeTraversal();

	}
	
	public BinaryTreeTraversal(){
		addNode(rootNode, 45); 
		  addNode(rootNode, 25); 
		  addNode(rootNode, 75); 
		  addNode(rootNode, 15); 
		  addNode(rootNode, 35); 
		  
		  System.out.println("BFS traversal.....");
		  BFSOfTree(rootNode);
		  
		  System.out.println("InOrder Traversal....");
		  inOrderTraversal(rootNode);
		  System.out.println();
		  
		  System.out.println("preOrder Traversal....");
		  preOrderTraversal(rootNode);
		  System.out.println();
		  
		  System.out.println("postOrder Traversal....");
		  postOrderTraversal(rootNode);
		  System.out.println();
	}
	
	private void postOrderTraversal(Tree rootNode) {
		if(rootNode==null){
			return;
		}
		
		postOrderTraversal(rootNode.getLeft());
		postOrderTraversal(rootNode.getRight());
		System.out.print(rootNode.getData()+",");
		
	}

	private void preOrderTraversal(Tree rootNode) {
		
		if(rootNode==null){
			return;
		}
		System.out.print(rootNode.getData()+",");
		preOrderTraversal(rootNode.getLeft());
		preOrderTraversal(rootNode.getRight());
		
	}

	private void inOrderTraversal(Tree rootNode) {
		if(rootNode==null){
			return;
		}
		
		inOrderTraversal(rootNode.getLeft());
		System.out.print(rootNode.getData()+",");
		inOrderTraversal(rootNode.getRight());
		
	}

	private void BFSOfTree(Tree rootNode) {
		if(rootNode==null){
			return;
		}
		
		Queue<Tree> queue = new LinkedList<>();
		queue.add(rootNode);
		while(!queue.isEmpty()){
			Tree temp = queue.poll();
			System.out.print(temp.getData()+",");
			if(temp.getLeft()!=null){
				queue.add(temp.getLeft());
			}
			if(temp.getRight()!=null){
				queue.add(temp.getRight());
			}
		}
		System.out.println();
		
	}

	private void addNode(Tree rootNode, int data) {
		
		if(rootNode==null){
			Tree node = new Tree(data);
			this.rootNode=node;
		}else{
			addInProperPlace(rootNode, data);
		}
	}

	private void addInProperPlace(Tree rootNode, int data) {
		if(data>=rootNode.data){
			if(rootNode.right==null){
				Tree node = new Tree(data);
				rootNode.setRight(node);
			}else{
				addNode(rootNode.getRight(), data);
			}
		}else{
			
			if(rootNode.left==null){
				Tree node = new Tree(data);
				rootNode.setLeft(node);
			}else{
				addNode(rootNode.getLeft(), data);
				
			}
			
		}
		
	}
	
	


	public static class Tree{
		private Integer data;
		private Tree left;
		private Tree right;
		
		public Tree(Integer data){
			this.data=data;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Tree getLeft() {
			return left;
		}

		public void setLeft(Tree left) {
			this.left = left;
		}

		public Tree getRight() {
			return right;
		}

		public void setRight(Tree right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Tree [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	



}
