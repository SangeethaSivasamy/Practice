/**
 * 
 */
package com.subrat.linkedList;

import java.util.HashSet;

/**
 * @author sparida
 *
 */
public class RemoveDuplicatesFromLinkedList {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicatesFromLinkedList removeDuplicatesFromLinkedList = new RemoveDuplicatesFromLinkedList();
		Node node = new Node(2);
		removeDuplicatesFromLinkedList.head=node;
		node.nextNode = new Node(2);
		node.nextNode.nextNode = new Node(5);
		node.nextNode.nextNode.nextNode = new Node(3);
		node.nextNode.nextNode.nextNode.nextNode=new Node(4);
		node.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(1);
		node.nextNode.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(4);
		removeDuplicatesFromLinkedList.displayList(node);
		removeDuplicatesFromLinkedList.removeDups(node);
		//removeDuplicatesFromLinkedList.removeDuplicatess(node);
		removeDuplicatesFromLinkedList.displayList(head);
		

	}
	
	/*private Node removeDuplicates(Node node) {
		if(node==null){
			return null;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Node next=node.nextNode;
		Node curr=node;
		Node temp;
		map.put(node.data, 1);
		while(next!=null){
			int data=next.data;
			if(map.containsKey(data)){
				curr.nextNode=next.nextNode;
				temp=next;
				next=next.nextNode;
				temp.nextNode=null;
				
			}else{
				map.put(node.data, 1);
				curr=next;
				next=next.nextNode;
			}
		}
		return node;
		
		
	}*/
	
	public void removeDuplicatess(Node n) {
	    HashSet<Integer> nodes = new HashSet<Integer>();
	    Node prev = null;
	    while (n != null) {
	        if (nodes.contains(n.data)) {
	            prev.nextNode= n.nextNode;
	        } else {
	            nodes.add(n.data);
	            prev = n;
	        }
	        n = n.nextNode;
	    }
	    prev.nextNode = null;
	}
	
	
	
	public void removeDups(Node n) {
	    while (n != null) {
	        Node curr = n;
	        while (curr.nextNode != null) {
	            if (curr.nextNode.data == n.data) {
	                curr.nextNode = curr.nextNode.nextNode;
	            } else {
	                curr = curr.nextNode;
	            }
	        }
	        n = n.nextNode;
	    }
		
	}

	private void displayList(Node node) {
		if(node==null){
			return;
		}
		Node temp = node;
		while(temp!=null){
			System.out.print(temp.data+"->");
			temp=temp.nextNode;
		}
		System.out.println();
		
	}

	private static class Node{
		private Node nextNode;
		private Integer data;
		
		public Node(Integer data){
			this.data = data;
			nextNode = null;
		}

		@Override
		public String toString() {
			return "Node [nextNode=" + nextNode + ", data=" + data + "]";
		}
		
		
	}

}
