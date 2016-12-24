/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class RemoveDuplicatesInALinkedList2ndWay {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesInALinkedList2ndWay removeDuplicatesInALinkedList2ndWay = new RemoveDuplicatesInALinkedList2ndWay();
		removeDuplicatesInALinkedList2ndWay.head = new Node(12);
		removeDuplicatesInALinkedList2ndWay.head.nextNode = new Node(11);
		removeDuplicatesInALinkedList2ndWay.head.nextNode.nextNode=new Node(12);
		removeDuplicatesInALinkedList2ndWay.head.nextNode.nextNode.nextNode=new Node(21);
		removeDuplicatesInALinkedList2ndWay.head.nextNode.nextNode.nextNode.nextNode=new Node(41);
		removeDuplicatesInALinkedList2ndWay.head.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(43);
		removeDuplicatesInALinkedList2ndWay.head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(21);
		printList(head);
		removeDuplicates(head);
		printList(head);

	}
	
	private static void removeDuplicates(Node head) {
		if(head==null){
			return;
		}
		Node ptr1=head;
		Node ptr2=head;
		Node temp=null;
		while(ptr1!=null && ptr1.nextNode!=null){
			while(ptr2.nextNode!=null){
				if(ptr1.data==ptr2.nextNode.data){
					temp=ptr2.nextNode;
					ptr2.nextNode=ptr2.nextNode.nextNode;
					System.gc();
				}else{
					ptr2=ptr2.nextNode;
				}
			}
			ptr1=ptr1.nextNode;
		}
		
	}

	private static void printList(Node head) {
		while(head!=null){
			System.out.print(head.data);
			head=head.nextNode;
			if(head!=null){
				System.out.print("->");
			}
		}
		System.out.print("->null");
		System.out.println();
		
	}

	private static class Node{
		private Integer data;
		private Node nextNode;
		
		public Node(Integer data){
			this.data=data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", nextNode=" + nextNode + "]";
		}
		
	}

}
