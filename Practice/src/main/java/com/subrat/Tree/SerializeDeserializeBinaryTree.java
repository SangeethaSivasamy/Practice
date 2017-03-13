/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 * 
 * http://javabypatel.blogspot.in/2016/10/serialize-deserialize-binary-tree.html
 * 
 * We will read the tree in Pre order traversal and store the node data in a string separated by comma.
Whenever we will encounter null node we will store "null" string against it as a indication that it is end of Tree.
Deserialization process is to convert Serialized string back to original Binary Tree
We use Preorder traversal for serializing the binary tree, So we will use the same traversal for converting string back to Binary tree.


We will convert the String into array for accessing Node data.

Start reading array element and for each element create a new Node.
(Because in Pre order traversal we first read Node data.)

Next element of array will be left child of newly created Node.
(Because in Pre order traversal we keep reading Left Subtree until we encounter null Node.)

After Left subtree is completed, Next element of array will be Right child of newly created Node.
(Because in Pre order traversal after left subtree, we keep reading Right Subtree until we encounter null Node.)
 *
 */
public class SerializeDeserializeBinaryTree {
	 
	 public static void main(String[] args) {
	 
	  Node rootNode=null; 
	  rootNode  = addNode(rootNode, 10, true);
	  rootNode  = addNode(rootNode, 5, true);
	  rootNode  = addNode(rootNode, 20, true);
	  rootNode  = addNode(rootNode, 3, true);
	  rootNode  = addNode(rootNode, 8, true);
	  rootNode  = addNode(rootNode, 7, true);
	 
	  String str = serializeBinaryTree(rootNode, "");
	  System.out.println(str);
	 
	  Node start = deserializeBinaryTree(str);
	  System.out.println(start);
	 }
	 
	 //Serialize Binary Tree
	 private static String serializeBinaryTree(Node rootNode, String str){
	  if(rootNode == null){
	   return "null,";
	  }
	 
	  StringBuilder sb  = new StringBuilder();
	  sb.append(rootNode.getData());
	  sb.append(",");
	 
	  sb.append(serializeBinaryTree(rootNode.getLeft(), str));
	  sb.append(serializeBinaryTree(rootNode.getRight(), str));
	  return sb.toString();
	 }
	 
	 //Deserialize Binary Tree
	 public static Node deserializeBinaryTree(String data){
	  String[] temp = data.split(",");
	  return deserialize(temp, new int[]{0});
	 }
	 
	 private static Node deserialize(String[] data, int[] index){ 
	  if(index[0] > data.length || data[index[0]].equals("null")){
	   index[0]++;
	   return null;
	  }
	 
	  //After reading the data, increment index value as indication to read next
	  //array value in further iteration
	  Node node = new Node(Integer.parseInt(data[index[0]++]));
	  node.setLeft(deserialize(data, index));
	  node.setRight(deserialize(data, index));
	 
	  return node;
	 }
	 
	 private static Node addNode(Node rootNode, int i, boolean isRootNode) {
	  if(rootNode==null){
	   return new Node(i);
	  }else{
	   if(i > rootNode.getData()){
	    if(isRootNode){
	     Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
	     rootNode.setRight(nodeToAdd);
	    }else{
	     Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
	     rootNode.setLeft(nodeToAdd);
	    }
	 
	   }else{
	    if(isRootNode){
	     Node nodeToAdd = addNode(rootNode.getLeft(), i, isRootNode);
	     rootNode.setLeft(nodeToAdd);
	    }else{
	     Node nodeToAdd = addNode(rootNode.getRight(), i, isRootNode);
	     rootNode.setRight(nodeToAdd);
	    }
	   }
	  }
	  return rootNode;
	 }
	 
	 private static class Node{
		  
		 private Node left;
		 private Node right;
		 private int data;
		  
		 public Node(int data){
		  this.data=data;
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
		 
		 public int getData() {
		  return data;
		 }
		 
		 public void setData(int data) {
		  this.data = data;
		 }
		}
	 
	}
