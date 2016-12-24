/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class ReverseALinkedListInAGroupOfGivenSize {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseALinkedListInAGroupOfGivenSize reverseALinkedListInAGroupOfGivenSize = new ReverseALinkedListInAGroupOfGivenSize();
		reverseALinkedListInAGroupOfGivenSize.head=new Node(1);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode=new Node(2);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode.nextNode=new Node(3);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode.nextNode.nextNode=new Node(4);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode.nextNode.nextNode.nextNode=new Node(5);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(6);
		reverseALinkedListInAGroupOfGivenSize.head.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(7);
		reverseALinkedListInAGroupOfGivenSize.printList(head);
		Node node =reverseALinkedListInAGroupOfGivenSize.reverseInAGroup(head,3);
		reverseALinkedListInAGroupOfGivenSize.printList(node);
	}
	
	private Node reverseInAGroup(Node head, int i) {
		if(head==null || i<1){
			return null;
		}
		
		Node curr=head;
		Node next=null;
		Node pre=null;
		int count=0;
		while(count<i && curr!=null){
			next=curr.nextNode;
			curr.nextNode=pre;
			pre=curr;
			curr=next;
			count++;
		}
		if(next!=null){
			head.nextNode=reverseInAGroup(curr, i);
		}
		return pre;
		
	}

	private void printList(Node head) {
		
		if(head==null){
			return;
		}
		
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

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}
		
		
	}

}
