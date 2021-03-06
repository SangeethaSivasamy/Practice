/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class CloneALinkedListPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(3);
		Node node4=new Node(4);
	    Node node5=new Node(5);
		
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		
		node1.random=node3;
		node2.random=node1;
		node3.random=node5;
		node4.random=node3;
		node5.random=node2;
		
		node5.next=null;
		Node head=node1;
		printList(head);
		Node node=clone(head);
		System.out.println();
		printList(head);
		

	}
	
	private static Node clone(Node node) {
		if(node==null){
			return node;
		}
		
		Node curr=node;
		while(curr!=null){
			Node temp = new Node();
			temp.data=curr.data;
			temp.next=curr.next;
			curr.next=temp;
			curr=curr.next.next;
		}
		
		curr = node;
		while(curr!=null){
			curr.next.random=curr.random.next;
			curr=curr.next.next;
		}
		
		curr=node;
		Node copy=node.next;
		while(curr.next!=null){
			curr=curr.next.next;
		}
		return copy;
		
	}

	private static void printList(Node node) {
		if(node==null){
			return;
		}
		
		while(node!=null){
			System.out.print(node);
			node=node.next;
			if(node!=null){
				System.out.print("->");
			}
		}
		
	}

	private static class Node{
		private Integer data;
		private Node next;
		private Node random;
		
		public Node(Integer data){
			this.data=data;
		}
		
		public Node(){
			
		}

		@Override
		public String toString() {
			return "[prev=" + getNullOrValue(this.random) + "][data="
					+ getNullOrValue(this) + "][next="
					+ getNullOrValue(this.next) + "]";
		}

		private String getNullOrValue(Node node) {
			return (node != null && node.data != null ? node.data : "null")
					.toString();
		}
		
		
		
		
	}

}
