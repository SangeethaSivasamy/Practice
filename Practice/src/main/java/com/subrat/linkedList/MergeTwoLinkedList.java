/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class MergeTwoLinkedList {
	
	private static Node head1;
	private static Node head2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeTwoLinkedList mergeTwoLinkedList = new MergeTwoLinkedList();
		mergeTwoLinkedList.head1 = new Node(1);
		mergeTwoLinkedList.head1.nextNode=new Node(3);
		mergeTwoLinkedList.head1.nextNode.nextNode=new Node(5);
		printList(head1);
		mergeTwoLinkedList.head2=new Node(2);
		mergeTwoLinkedList.head2.nextNode=new Node(4);
		mergeTwoLinkedList.head2.nextNode.nextNode=new Node(6);
		printList(head2);
		Node node = mergeTwoLinkedList.mergeList(head1,head2);
		printList(node);
	}
	
	private static void printList(Node node) {
		if(node==null){
			return;
		}
		
		while(node!=null){
			System.out.print(node.data);
			node=node.nextNode;
			if(node!=null){
				System.out.print("->");
			}
		}
		
		System.out.print("->null");
		System.out.println();
	}

	private Node mergeList(Node head1, Node head2) {
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		if(head1.data<head2.data){
			head1.nextNode=mergeList(head1.nextNode, head2);
			return head1;
		}else{
			head2.nextNode=mergeList(head1, head2.nextNode);
			return head2;
		}
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
		@Override
		public String toString() {
			return "Node [data=" + data + ", nextNode=" + nextNode + "]";
		}
		
	}

}
