/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 * 
 * http://www.geeksforgeeks.org/in-place-conversion-of-sorted-dll-to-balanced-bst/
 * 
 * 
 * Method 1 (Simple)
Following is a simple algorithm where we first find the middle node of list and make it root of the tree to be constructed.

1) Get the Middle of the linked list and make it root.
2) Recursively do same for left half and right half.
       a) Get the middle of left half and make it left child of the root
          created in step 1.
       b) Get the middle of right half and make it right child of the
          root created in step 1.
          
 * 
 * Method 2 (Tricky) 
The method 1 constructs the tree from root to leaves. In this method, we construct from leaves to root. The idea is to insert nodes in BST in the same order as the appear in Doubly Linked List, so that the tree can be constructed in O(n) time complexity. We first count the number of nodes in the given Linked List. Let the count be n. After counting nodes, we take left n/2 nodes and recursively construct the left subtree. After left subtree is constructed, we assign middle node to root and link the left subtree with root. Finally, we recursively construct the right subtree and link it with root.
While constructing the BST, we also keep moving the list head pointer to next so that we have the appropriate pointer in each recursive call.
 *
 */
public class SortedLinkedListToBalancedBST {
	 LinkedListNode head;
	  
	 public static void main(String[] args) {
	  new SortedLinkedListToBalancedBST();
	 }
	 
	 public SortedLinkedListToBalancedBST(){
	  head = new LinkedListNode(1);
	  LinkedListNode lln2 = new LinkedListNode(2);
	  LinkedListNode lln3 = new LinkedListNode(3);
	  LinkedListNode lln4 = new LinkedListNode(4);
	  LinkedListNode lln5 = new LinkedListNode(5);
	  LinkedListNode lln6 = new LinkedListNode(6);
	  LinkedListNode lln7 = new LinkedListNode(7);
	 
	  head.setNext(lln2);
	  lln2.setNext(lln3);
	  lln3.setNext(lln4);
	  lln4.setNext(lln5);
	  lln5.setNext(lln6);
	  lln6.setNext(lln7);
	   
	  /*Node balancedBSTTopDown = sortedLinkedListToBalancedBSTTopDown(head);
	  printTreeInOrder(balancedBSTTopDown);*/
	 
	  Node balancedBSTBottomUp = sortedLinkedListToBalancedBSTBottomUp(head);
	  printTreeInOrder(balancedBSTBottomUp);
	 }
	 
	 private Node sortedLinkedListToBalancedBSTBottomUp(LinkedListNode list){
	  int length = getLengthOfLinkedList(list);
	  return sortedLinkedListToBST(length);
	 } 
	 
	 private Node sortedLinkedListToBST(int length){
	  if(length <= 0){
	   return null;
	  }
	   
	  Node left = sortedLinkedListToBST(length/2);
	   
	  Node root = new Node(head.getData());
	  root.setLeft(left);
	   
	  head = head.getNext();
	    
	  root.setRight(sortedLinkedListToBST(length - length/2 - 1));
	  return root;
	 } 
	 
	 private int getLengthOfLinkedList(LinkedListNode list){
	  if(list==null){
	   return 0;
	  }
	  int count = 1;
	  while((list = list.getNext()) != null){
	   count++;
	  }
	  return count;
	 } 
	 
	 private Node sortedLinkedListToBalancedBSTTopDown(LinkedListNode lln){
	  if(lln==null){
	   return null;
	  }
	  if(lln.getNext()==null){
	   return new Node(lln.getData());
	  }
	 
	  LinkedListNode tortoise = lln;
	  LinkedListNode hare = lln;
	  LinkedListNode previous = null;
	 
	  while(hare!=null && hare.getNext()!=null){
	   hare = hare.getNext().getNext();
	   previous = tortoise;
	   tortoise = tortoise.getNext();
	  }
	 
	  LinkedListNode middle = tortoise;
	  if(previous!=null){
	   middle = previous.getNext();
	   previous.setNext(null);
	  }
	 
	  Node node = new Node(middle.getData());
	  node.setLeft(sortedLinkedListToBalancedBSTTopDown(lln));
	  node.setRight(sortedLinkedListToBalancedBSTTopDown(middle.getNext()));
	  return node;  
	 }
	 
	 private void printTreeInOrder(Node rootNode){
	  if(rootNode==null)
	   return;
	  printTreeInOrder(rootNode.getLeft());
	  System.out.print(rootNode.getData() + " ");
	  printTreeInOrder(rootNode.getRight());
	 }
	 
	 class Node{
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
	
	
	
	class LinkedListNode{
	 private int data;
	 private LinkedListNode next;
	 
	 public LinkedListNode(int data) {
	  this.data = data;
	 }
	 
	 public int getData() {
	  return data;
	 }
	 
	 public void setData(int data) {
	  this.data = data;
	 }
	 
	 public LinkedListNode getNext() {
	  return next;
	 }
	 
	 public void setNext(LinkedListNode next) {
	  this.next = next;
	 }
	}
