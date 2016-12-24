/**
 * 
 */
package com.subrat.Tree;
/**
 * @author sparida
 *
 */
public class FindDiameterOfBinaryTree {
	 
	 private Node rootNode;
	 
	 public static void main(String[] args) {
	  new FindDiameterOfBinaryTree();
	 }
	 
	 public FindDiameterOfBinaryTree(){
	  addNode(rootNode, 100);
	  addNode(rootNode, 90);
	  addNode(rootNode, 150);
	  addNode(rootNode, 80);
	  addNode(rootNode, 95);
	  addNode(rootNode, 70);
	  addNode(rootNode, 92);
	  addNode(rootNode, 60);
	  addNode(rootNode, 94);
	 
	  System.out.println(getDiameterOfBinaryTree(rootNode));
	 }
	 
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
	 
	}