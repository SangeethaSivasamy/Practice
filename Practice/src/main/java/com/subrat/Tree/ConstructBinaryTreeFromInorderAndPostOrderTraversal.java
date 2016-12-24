/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
	 
	 public static void main(String[] args) {
	  new ConstructBinaryTreeFromInorderAndPostOrderTraversal();
	 }
	 
	 public ConstructBinaryTreeFromInorderAndPostOrderTraversal() {
	  int inOrder[] =   {20, 30, 35, 40, 45, 50, 55, 60, 70};
	  int postOrder[] = {20, 35, 30, 45, 40, 55, 70, 60, 50};
	  
	  Node n = constructTree(inOrder, postOrder);
	  System.out.println(n);
	 }
	 
	 
	 private static Node constructTree(int[] inOrder, int[] preorder) {
	  return constructTreeFromInOrderAndPostOrder(inOrder, 0, inOrder.length-1, preorder, 0, preorder.length-1);
	 }
	 
	 private static Node constructTreeFromInOrderAndPostOrder(int[] inOrder, int inStart, int inEnd, int[] postOrder, int postStart, int postEnd) {
	  if(postStart > postEnd){
	   return null;
	  }
	 
	  Node node = new Node(postOrder[postEnd]);
	 
	  int index=0;
	  for (int i = inStart; i <= inEnd; i++) {
	   if(postOrder[postEnd]==inOrder[i]){
	    index = i;
	    break;
	   }  
	  }
	   
	  int numberOfNodes = index - inStart;
	   
	  node.setLeft(constructTreeFromInOrderAndPostOrder(inOrder, inStart, index-1, postOrder, postStart, (postStart + numberOfNodes)-1));
	  node.setRight(constructTreeFromInOrderAndPostOrder(inOrder, index+1, inEnd, postOrder, postStart + numberOfNodes, postEnd-1));
	 
	  return node;
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
