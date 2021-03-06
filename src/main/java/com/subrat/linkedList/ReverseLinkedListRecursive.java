/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class ReverseLinkedListRecursive {
	   private Node head;
	    public Node getHead() {
	    return head;
	    }     

	    public void setHead(Node head) {
	        this.head = head;
	    }         

	    public void reverseLinkedListRecursive() {
	        reverseLinkedListRecursive(head);
	    }         

	    private void reverseLinkedListRecursive(Node curr) {
	 
	        if (curr == null) {
	            return;
	        }
	 
	        if (curr.getNext() == null) {
	            this.head = curr;
	            return;
	        }
	 
	        reverseLinkedListRecursive(curr.getNext());
	        curr.getNext().setNext(curr);
	        curr.setNext(null);
	    }         

	    public static void main(String[] args) {
	         
	        ReverseLinkedListRecursive list = new ReverseLinkedListRecursive();
	        list.createTestList(5);
	        list.printlist();
	        list.reverseLinkedListRecursive();
	        list.printlist();
	    }    

	    public void createTestList(int n) {
	         
	        if(n < 1)
	            return;
	         
	        int i = 1;
	        Node temp = null;
	        while(i <= n) {
	            Node node = new Node(i);       
	            if(head == null) {
	                head = node;
	                temp = head;
	            } else {
	                temp.setNext(node);
	                temp = node;
	            }
	            i++;
	        }
	    }           

	    public void printlist() {
	         
	        Node temp = head;
	        while(temp != null) {
	            System.out.print(temp.getData() + " -> ");
	            temp = temp.getNext();
	        }
	        System.out.println("X");
	    } 

	    class Node {
	                 
	        private int data;        
	        private Node next;         

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

	        public Node(int data) {
	            super();
	            this.data = data;
	        }     
	    }
	} 