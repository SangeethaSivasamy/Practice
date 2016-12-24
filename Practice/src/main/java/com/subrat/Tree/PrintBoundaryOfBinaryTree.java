/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class PrintBoundaryOfBinaryTree {
	 private Node rootNode=null;
	 
	 public static void main(String[] args) {
	  new PrintBoundaryOfBinaryTree();
	 }
	 
	 public PrintBoundaryOfBinaryTree(){
	  addNode(rootNode, 100); 
	  addNode(rootNode, 50); 
	  addNode(rootNode, 150); 
	  addNode(rootNode, 25); 
	  addNode(rootNode, 75); 
	  addNode(rootNode, 140); 
	  addNode(rootNode, 142); 
	  addNode(rootNode, 30); 
	  addNode(rootNode, 70); 
	  addNode(rootNode, 80); 
	  addNode(rootNode, 35); 
	   
	  printBoundary(rootNode);  
	 }
	 
	 private void printBoundary(Node rootNode) {
	  if(rootNode!=null){
	   printRoot(rootNode);
	    
	   if(rootNode.getLeft()!=null)
	    printLeft(rootNode.getLeft());
	    
	   printLeaf(rootNode);
	    
	   if(rootNode.getRight()!=null)
	    printRight(rootNode.getRight());   
	  }
	 }
	 
	 private void printRoot(Node rootNode) {
	  System.out.print(rootNode.getData() + " ");
	 }
	 
	 private void printLeft(Node rootNode){
	  if(rootNode==null){
	   return;
	  }
	  if(rootNode.getLeft()==null && rootNode.getRight()==null){
	   return;
	  }
	 
	  System.out.print(rootNode.getData() + " ");
	 
	  if(rootNode.getLeft()==null){
	   printLeft(rootNode.getRight());
	  }else{
	   printLeft(rootNode.getLeft());
	  }
	 }
	 
	 private void printLeaf(Node rootNode){
	  if(rootNode==null){
	   return;
	  }
	 
	  if(rootNode.getLeft()==null && rootNode.getRight()==null){
	   System.out.print(rootNode.getData() + " ");
	   return;
	  }
	  printLeaf(rootNode.getLeft());
	  printLeaf(rootNode.getRight());
	 }
	 
	 private void printRight(Node rootNode){
	  if(rootNode==null){
	   return;
	  }
	  if(rootNode.getLeft()==null && rootNode.getRight()==null){
	   return;
	  }
	 
	  if(rootNode.getRight()==null){
	   printRight(rootNode.getLeft());
	   System.out.print(rootNode.getData() + " ");
	 
	  }else{
	   printRight(rootNode.getRight());
	   System.out.print(rootNode.getData() + " ");
	  }  
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
		 private int data;
		 private Node left;
		 private Node right;
		 
		 public Node(int data) {
		  this.data=data;
		 }
		 
		 public int getData() {
		  return data;
		 }
		 public void setData(int data) {
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
		} 
	}