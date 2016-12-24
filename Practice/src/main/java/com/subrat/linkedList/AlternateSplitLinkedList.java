/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class AlternateSplitLinkedList {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlternateSplitLinkedList alternateSplitLinkedList = new AlternateSplitLinkedList();
		alternateSplitLinkedList.head=new Node(1);
		alternateSplitLinkedList.head.nextNode=new Node(2);
		alternateSplitLinkedList.head.nextNode.nextNode=new Node(3);
		alternateSplitLinkedList.head.nextNode.nextNode.nextNode=new Node(4);
		alternateSplitLinkedList.head.nextNode.nextNode.nextNode.nextNode=new Node(5);
		alternateSplitLinkedList.head.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(6);
		alternateSplitLinkedList.printList(head);
		Node node =alternateSplitLinkedList.splitList(head);
		alternateSplitLinkedList.printList(node);

	}
	
	private Node splitList(Node head) {
	if(head==null){
		return null;
	}
	Node n1=head;
	Node temp=n1;
	Node headNode=n1.nextNode;
	Node n2=headNode;
	//Node n2=head.nextNode;
	
	while(n1!=null && n1.nextNode!=null){
		n1.nextNode=n1.nextNode.nextNode;
		if(n2.nextNode!=null){
			n2.nextNode=n2.nextNode.nextNode;
		}
		n1=n1.nextNode;
		n2=n2.nextNode;
	}
	AlternateSplitLinkedList alternateSplitLinkedList = new AlternateSplitLinkedList();
	alternateSplitLinkedList.printList(temp);
	return headNode;
		
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
	}

}
