/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class ReturnStartNodeOfLoopInLinkList {
	  
	 Node startNode;
	 
	 public static void main(String[] args) {
	  
	  ReturnStartNodeOfLoopInLinkList g = new ReturnStartNodeOfLoopInLinkList();
	   
	  Node n1 = g.new Node(10);
	  Node n2 = g.new Node(20);
	  Node n3 = g.new Node(30);
	  Node n4 = g.new Node(40);
	  Node n5 = g.new Node(50);
	  Node n6 = g.new Node(60);
	  Node n7 = g.new Node(70);
	  Node n8 = g.new Node(80);
	   
	  g.startNode = n1;
	   
	  n1.setNext(n2);
	  n2.setNext(n3);
	  n3.setNext(n4);
	  n4.setNext(n5);
	  n5.setNext(n6);
	  n6.setNext(n7);
	  n7.setNext(n8);
	  n8.setNext(n6);
	   
	  Node loopNode = g.getStartNodeOfLoopInLinklist(g.startNode);
	   
	  if(loopNode==null){
	   System.out.println("Loop not present");
	  }else{
	   System.out.println("Start node of Loop is :"+loopNode.getData()); 
	  }
	 }
	  
	 private Node getStartNodeOfLoopInLinklist(Node startNode){
	  Node tortoisePointer = startNode; // Initially ptr1 is at starting location.
	  Node harePointer = startNode; // Initially ptr2 is at starting location.
	   
	  // If ptr2 encounters NULL, it means there is no Loop in Linked list.
	  while(harePointer!=null && harePointer.getNext()!=null){
	   tortoisePointer = tortoisePointer.getNext(); // ptr1 moving one node at at time
	   harePointer = harePointer.getNext().getNext(); // ptr2 moving two nodes at at time
	    
	   // if ptr1 and ptr2 meets, it means linked list contains loop.
	   if(tortoisePointer==harePointer){ 
	     
	    //After meet, moving tortoisePointer to start node of list.
	    tortoisePointer = startNode; 
	     
	    //Moving tortoisePointer and harePointer one node at a time till the time they meet at common point. 
	    while(tortoisePointer!=harePointer){ 
	     tortoisePointer = tortoisePointer.getNext(); 
	     harePointer = harePointer.getNext();
	    }
	     
	    //returning start node of loop.
	    return tortoisePointer;
	     
	   }
	  }
	   
	  // this condition will arise when there is no loop in list.
	  return null; 
	 }
	 
	 class Node{
		  
		 private int data;
		 private Node next;
		  
		 public Node(int data) {
		  this.data = data;
		 }
		 public int getData() {
		  return data;
		 }
		 public void setData(int data) {
		  this.data = data;
		 }
		 public Node getNext() {
		  return next;
		 }
		 public void setNext(Node next) {
		  this.next = next;
		 }
		}
	  
	}