/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class MiddleElementOfALinkedList {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MiddleElementOfALinkedList middleElementOfALinkedList = new MiddleElementOfALinkedList();
		for (int i = 9; i >0; i--) {
			middleElementOfALinkedList.push(i);
		}
		middleElementOfALinkedList.printList(head);
		int data=middleElementOfALinkedList.findMiddleElement(head);
		System.out.println(data);

	}

	static int findMiddleElement(Node head) {
		if(head==null){
			return 0;
		}
		Node slow = head;
		Node fast = head;
		while(fast!=null && fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow.data;
		
		
	}

	private void printList(Node head) {
		
		if(head==null){
			return;
		}
		//Node temp = head;
		while(head!=null){
			System.out.print("->"+head.data);
			head=head.next;
			
		}
		System.out.print("->null");
		System.out.println();
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next=this.head;
		head=newNode;
		
	}

}
