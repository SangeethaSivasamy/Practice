/**
 * 
 */
package com.subrat.Tree;
/**
 * @author sparida
 *
 */
public class FindKLargestElementInBinarySearchTree {
	 private Node rootNode;
	 private static int counter;
	 
	 public static void main(String[] args) {
	  new FindKLargestElementInBinarySearchTree();
	 }
	 
	 public FindKLargestElementInBinarySearchTree() {
	  addNode(rootNode, 40); 
	  addNode(rootNode, 20); 
	  addNode(rootNode, 60); 
	  addNode(rootNode, 10); 
	  addNode(rootNode, 30);
	  addNode(rootNode, 50);
	  addNode(rootNode, 70);
	   
	  printTreeInOrder(rootNode);
	  System.out.println();
	 
	  int kthLargestNode = findKthLargestItem(rootNode, 7);
	  if(kthLargestNode==-1){
	   System.out.println("Kth largest element not found.");
	  }else{
	   System.out.println("Kth largest element is :"+kthLargestNode);
	  }  
	 }
	  
	 private int findKthLargestItem(Node rootNode, int k) {
	  if(rootNode==null){
	   return -1;
	  }
	 
	  int childCount = getNodeCount(rootNode.getRight());
	   
	  if(childCount+1==k){
	   return rootNode.getData();
	   
	  }else if(childCount+1>=k){
	   return findKthLargestItem(rootNode.getRight(), k);
	  }else{
	   return findKthLargestItem(rootNode.getLeft(), k - (childCount+1));
	  }
	 }
	  
	 private int getNodeCount(Node node){
	  if(node == null){
	   return 0;
	  }
	  int left = getNodeCount(node.getLeft());
	  int right = getNodeCount(node.getRight());
	   
	  return 1 + left + right;
	 }
	  
	 private void printTreeInOrder(Node rootNode){
	  if(rootNode==null)
	   return;
	  printTreeInOrder(rootNode.getLeft());
	  System.out.print(rootNode.getData() + " ");
	  printTreeInOrder(rootNode.getRight());
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