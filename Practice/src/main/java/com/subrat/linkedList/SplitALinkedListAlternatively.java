/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class SplitALinkedListAlternatively {
	
	private static Node head;
	private static Node headA;
	private static Node headB;
	
	private static class Node{
		private Integer data;
		private Node next;
		
		public Node(Integer data){
			this.data=data;
			this.next=null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node node1=new Node(1);
		Node node2=new Node(2);
		Node node3=new Node(1);
		Node node4=new Node(2);
		Node node5=new Node(1);
		Node node6=new Node(2);
		node1.next=head;
		head=node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		SplitALinkedListAlternatively splitALinkedListAlternatively = new SplitALinkedListAlternatively();
		splitALinkedListAlternatively.split(head);
		printList(headA);
		printList(headB);
	}

	private static void printList(Node head) {
		while(head!=null){
			System.out.print(head.data);
			head=head.next;
			if(head!=null){
				System.out.print("->");
			}
		}
		System.out.println();
		
	}

	private void split(Node head) {
		if(head==null || head.next==null){
			return ;
		}
		
		Node curr = head;
		headA=curr;
		headB=curr.next;
		while(curr!=null && curr.next!=null){
			Node t=curr.next;
			curr.next=t.next;
			if(curr.next!=null && curr.next.next!=null){
				t.next=curr.next.next;
			}else{
				t.next=null;
				return;
			}
			curr=curr.next;
		}
		
		
	}

}
