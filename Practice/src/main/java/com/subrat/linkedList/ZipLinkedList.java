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
		
		
	}

	private void displayList(Node head) {
		if(head==null){
			return;
		}
		while(head!=null){
			System.out.print("->"+head.data);
			head=head.next;
		}
		System.out.println("->null");
		
	}

	private void push(int i) {
		Node newNode = new Node(i);
		newNode.next=head;
		head=newNode;
		
	}

}
