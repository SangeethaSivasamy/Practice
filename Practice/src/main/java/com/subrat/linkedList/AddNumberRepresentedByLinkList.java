/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 * http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 *
 */
public class AddNumberRepresentedByLinkList {
	
	private static Node head;
	private static Node head1;
	private int carry =0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddNumberRepresentedByLinkList obj = new AddNumberRepresentedByLinkList();
		obj.head=new Node(9);
		obj.head.next=new Node(8);
		obj.head.next.next=new Node(9);
		
		obj.head1=new Node(9);
		obj.head1.next=new Node(9);
		//obj.head1.next.next=new Node(4);
		
		Node result = obj.addTwoNumbers(head,head1);
        print(result);

	}
	
	private static void print(Node node){
		if(node==null){
			return;
		}
		Node curr = node;
		while(curr!=null){
			System.out.println(curr.data+",");
			curr=curr.next;
		}
	}
	
	private Node addTwoNumbers(Node l1, Node l2) {
	       int carry =0;
	 
	        Node newHead = new Node(0);
	        Node p1 = l1, p2 = l2, p3=newHead;
	 
	        while(p1 != null || p2 != null){
	            if(p1 != null){
	                carry += p1.data;
	                p1 = p1.next;
	            }
	 
	            if(p2 != null){
	                carry += p2.data;
	                p2 = p2.next;
	            }
	 
	            p3.next = new Node(carry%10);
	            p3 = p3.next;
	            carry /= 10;
	        }
	 
	        if(carry==1) 
	            p3.next=new Node(1);
	 
	        return newHead.next;
	    }
	
	
	
	private static class Node{
		Integer data;
		Node next;
		
		public Node(Integer data){
			this.data=data;
		}		
		
		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
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
