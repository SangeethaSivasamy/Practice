/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 * 
 * I/P------->    1->2->3->4->5->6->null
   O/P------->    1->6->2->5->3->4->null
 *
 */
public class ZipLinkedListWorking {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZipLinkedListWorking zipLinkedListWorking = new ZipLinkedListWorking();
		zipLinkedListWorking.head=new Node(1);
		zipLinkedListWorking.head.nextNode=new Node(2);
		zipLinkedListWorking.head.nextNode.nextNode=new Node(3);
		zipLinkedListWorking.head.nextNode.nextNode.nextNode=new Node(4);
		zipLinkedListWorking.head.nextNode.nextNode.nextNode.nextNode=new Node(5);
		zipLinkedListWorking.head.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(6);
		printNode(head);
		Node middleNode =zipLinkedListWorking.middleElement(head);
		Node newHead=middleNode.nextNode;
		middleNode.nextNode=null;
		Node reversed=reversed(newHead);
		printNode(reversed);
		printNode(head);
		Node p=reversed;
		Node q=head;
		Node merged=new Node();
		Node temp=merged;
		while(p!=null && q!=null){
			temp.nextNode=q;
			q=q.nextNode;
			temp=temp.nextNode;
			
			temp.nextNode=p;
			p=p.nextNode;
			temp=temp.nextNode;
		}
		while(q!=null){
			temp.nextNode=q;
			q=q.nextNode;
		}
		
		while(p!=null){
			temp.nextNode=p;
			p=p.nextNode;
		}
		
		printNode(merged.nextNode);

	}
	
	
	
	private static void printNode(Node head) {
		if(head==null){
			return;
		}
		while(head!=null){
			System.out.print(head.data);
			head=head.nextNode;
			System.out.print("->");
			
		}
		System.out.print("null");
		System.out.println();
	}



	private static Node reversed(Node newHead) {
		if(newHead==null){
			return null;
		}
		Node curr=newHead;
		Node next=curr;
		Node pre=null;
		while(curr!=null){
			next=curr.nextNode;
			curr.nextNode=pre;
			pre=curr;
			curr=next;
		}
		return pre;
	}

	private Node middleElement(Node head) {
		Node slow=head;
		Node fast=head;
		while(fast!=null && fast.nextNode!=null && fast.nextNode.nextNode!=null){
			slow=slow.nextNode;
			fast=fast.nextNode.nextNode;
		}
		return slow;
		
		
	}

	private static class Node{
		private Integer data;
		private Node nextNode;
		
		public Node(Integer data){
			this.data=data;
		}
		
		public Node(){
			
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

		@Override
		public String toString() {
			return "Node [data=" + data + ", nextNode=" + nextNode + "]";
		}
		
		
	}

}
