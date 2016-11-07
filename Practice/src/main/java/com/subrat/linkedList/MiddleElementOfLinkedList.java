/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class MiddleElementOfLinkedList {
	
	private static Node head;
	
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MiddleElementOfLinkedList middleElementOfLinkedList = new MiddleElementOfLinkedList();
		Node node = new Node(1);
		node.nextNode = new Node(2);
		node.nextNode.nextNode=new Node(3);
		node.nextNode.nextNode.nextNode=new Node(4);
		node.nextNode.nextNode.nextNode.nextNode = new Node(5);
		node.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(6);
		node.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(7);
		Node middleElement = middleElementOfLinkedList.findMiddleElement(node);
		System.out.println(middleElement.data);
	}
	
	private Node findMiddleElement(Node head) {
		Node fast = head.nextNode;
		Node slow = head;
		while(fast!=null && fast.nextNode!=null){
			slow = slow.nextNode;
			fast = fast.nextNode.nextNode;
		}
		return slow;
	}

	private static class Node{
		private Node nextNode;
		private Integer data;
		
		public Node(Integer data){
			this.data = data;
			nextNode=null;
		}

		@Override
		public String toString() {
			return "Node [nextNode=" + nextNode + ", data=" + data + "]";
		}
		
		
	}

}
