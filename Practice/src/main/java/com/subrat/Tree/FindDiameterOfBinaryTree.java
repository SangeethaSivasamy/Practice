/**
 * 
 */
package com.subrat.Tree;
/**
 * @author sparida
 *
 */
public class FindDiameterOfBinaryTree {
	 
	 private static Node rootNode;
	 
	 public static void main(String[] args) {
		 
		 FindDiameterOfBinaryTree findDiameterOfBinaryTree = new FindDiameterOfBinaryTree();
	 // new FindDiameterOfBinaryTree();
	// }
	 
	// public FindDiameterOfBinaryTree(){
		 findDiameterOfBinaryTree.addNode(rootNode, 100);
		 findDiameterOfBinaryTree.addNode(rootNode, 90);
		 findDiameterOfBinaryTree.addNode(rootNode, 150);
		 findDiameterOfBinaryTree.addNode(rootNode, 80);
		 findDiameterOfBinaryTree.addNode(rootNode, 95);
		 findDiameterOfBinaryTree.addNode(rootNode, 70);
		 findDiameterOfBinaryTree.addNode(rootNode, 92);
		 findDiameterOfBinaryTree.addNode(rootNode, 60);
		 findDiameterOfBinaryTree.addNode(rootNode, 94);
	 
	 // System.out.println(getDiameterOfBinaryTree(rootNode));
	  
	  
	  System.out.println(findDiameterOfBinaryTree.diameter());
	 }
	 //O(n2)
	 private int getDiameterOfBinaryTree(Node node){
	  if(node == null){
	   return 0;
	  }
	  int leftSubtreeHeight = height(node.getLeft());
	  int rightSubtreeHeight = height(node.getRight());
	   
	  int diameterOfNode = leftSubtreeHeight + rightSubtreeHeight + 1;
	   
	  int leftDiameter = getDiameterOfBinaryTree(node.getLeft());
	  int rightDiameter = getDiameterOfBinaryTree(node.getRight());
	 
	  return max(diameterOfNode, max(leftDiameter, rightDiameter));
	 }
	 
	 int diameter()
	    {
	        Height height = new Height();
	        return diameterOpt(rootNode, height);
	    }

	 //O(n)
	int diameterOpt(Node root, Height height) {

		Height lh = new Height();
		Height rh = new Height();

		if (root == null) {
			height.h = 0;
			return 0;
		}

		int ldiameter = diameterOpt(root.left, lh);
		int rdiameter = diameterOpt(root.right, rh);

		height.h = Math.max(lh.h, rh.h) + 1;

		return Math.max(lh.h + rh.h + 1, Math.max(ldiameter, rdiameter));
	}
	 
	  
	 private int height(Node node){
	  if( node == null){
	   return 0;
	  }
	  int lHeight = height(node.getLeft());
	  int rHeight = height(node.getRight());
	  return (max(lHeight , rHeight)+1);
	 }
	  
	 private int max(int a, int b){
	  return a > b ? a : b;
	 }
	  
	 private void addNode(Node rootNode, int data){
	  if(rootNode==null){
	   Node temp1 = new Node(data);
	   this.rootNode=temp1;
	  }else{
	   addNodeInProperPlace(rootNode, data);
	  }
	 }
	 
	 private void addNodeInProperPlace(Node rootNode, int data){ 
	  if(data>rootNode.getData()){
	   if(rootNode.getRight()!=null){
	    addNode(rootNode.getRight(), data);
	   }else{
	    Node temp1 = new Node(data);
	    rootNode.setRight(temp1);
	   }
	  }else if(data<rootNode.getData()){
	   if(rootNode.getLeft()!=null){
	    addNode(rootNode.getLeft(), data);
	   }else{
	    Node temp1 = new Node(data);
	    rootNode.setLeft(temp1);
	   }
	  }
	 }
	 private static class Node{
		 private Integer data;
		 private Node left;
		 private Node right;
		 
		 public Node(Integer data){
			 this.data=data;
		 }

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		 
	 }
	 class Height{
		 int h;
	 }
	 
	}