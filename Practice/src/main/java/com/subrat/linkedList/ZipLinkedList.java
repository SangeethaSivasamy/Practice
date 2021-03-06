/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class ZipLinkedList {
	
	private static Node head;
	private static Node temp;
	private static Node temp1;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ZipLinkedList zipLinkedList = new ZipLinkedList();
		for (int i = 6; i>=1 ; i--) {
			zipLinkedList.push(i);
		}
		zipLinkedList.displayList(head);
		zipLinkedList.doZip(head);
		
	}

	private void doZip(Node head) {
		int length= size(head);
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		Node endNode=curr;
		for (int i = 0; i <length/2; i++) {
			ZipLinkedList.pushinTemp(curr);
			ZipLinkedList.pushinTemp1(endNode);
			
		}
		ZipLinkedList zipLinkedList = new ZipLinkedList();
		zipLinkedList.displayList(temp);
		
		
	}

	private static void pushinTemp1(Node endNode) {
		
		
	}

	private static void pushinTemp(Node node) {
		
		
	}

	private int size(Node head) {
		int count =0;
		while(head!=null){
			count++;
			head=head.next;
		}
		
		return count;
	}

	private void displayList(Node head) {
		if(head==null){
			return;
		}
		while(head!=null){
			System.out.print(head.data);
			head=head.next;
			if(head!=null){
				System.out.print("->");
			}
		}
		System.out.print("->null");
		System.out.println();
		
	}

	private static void push(int i) {
		Node newNode = new Node(i);
		newNode.next=head;
		head=newNode;
		
	}

}
