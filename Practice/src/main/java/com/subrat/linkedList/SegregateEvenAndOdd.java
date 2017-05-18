/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class SegregateEvenAndOdd {
	
	private Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SegregateEvenAndOdd obj = new SegregateEvenAndOdd();
		obj.head=new Node(11);
		obj.head.next=new Node(10);
		obj.head.next.next=new Node(8);
		obj.head.next.next.next=new Node(3);
		obj.head.next.next.next.next=new Node(4);
		obj.head.next.next.next.next.next=new Node(2);
		obj.head.next.next.next.next.next.next=new Node(0);
        Node result =obj.segregateEvenOdd();
        System.out.println("Modified Linked List");
        obj.printList(result);
        }
	
	private void printList(Node result) {
		while(result!=null){
			System.out.print(result.data+",");
			result=result.next;
		}
		
	}
//11->10->8->3->4->2->0
	private Node segregateEvenOdd() {
		Node oddHead  = null, evenHead = null, oddStart = null, evenStart = null;
		Node current = head;
		
		while(current != null)	{
			
			if(current.getData() % 2 == 0)		// if even
				if(evenHead == null)
					evenStart = evenHead = current;
				else	{
					evenHead.setNext(current);
					evenHead = evenHead.getNext();
				}
			else								// if odd
				if(oddHead == null)
					oddStart = oddHead = current;
				else	{
					oddHead.setNext(current);				
					oddHead = oddHead.getNext();
				}
			
			current = current.getNext();
		}
		
		evenHead.setNext(oddStart);   
		oddHead.setNext(null);
		
		return evenStart;
	}

	
	private static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
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
