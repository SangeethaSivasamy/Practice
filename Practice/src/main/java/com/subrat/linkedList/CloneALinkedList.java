/**
 * 
 */
package com.subrat.linkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class CloneALinkedList {
	
	
	public static void main(String[] args) {
		
		Node<Integer> node1 = new Node<Integer>(1);
		Node<Integer> node2 = new Node<Integer>(2);
		Node<Integer> node3 = new Node<Integer>(3);
		Node<Integer> node4 = new Node<Integer>(4);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node1.random = node3;
		node2.random = node4;
		node3.random = node1;
		node4.random = node2;

		node4.next = null;
		Node head = node1;
		printList(head);
		Node node = cloneNoExtraSpace(head);
		//Node node = cloneExtraSpace(head);
		printList(node);
		

	}

	public static void printList(Node<Integer> root) {
		System.out.println("\n");
		Node<Integer> head = root;
		while (head != null) {
			System.out.print(head);
			head = head.next;
			if (head != null) {
				System.out.print("-->");
			}
		}
	}
	
	public static Node cloneExtraSpace(Node n) {
	    if (n == null) return n;
	 
	    HashMap<Node, Node> mapping = new HashMap<Node, Node>();
	 
	    Node copy = new Node();
	    Node nCurr = n, copyCurr = copy;
	 
	    while (nCurr.next != null) {
	        mapping.put(nCurr, copyCurr);
	        copyCurr.next = new Node();
	        nCurr = nCurr.next;
	        copyCurr = copyCurr.next;
	    }
	 
	    nCurr = n;
	    copyCurr = copy;
	 
	    while (nCurr != null) {
	        copyCurr.random = mapping.get(nCurr.random);
	        nCurr = nCurr.next;
	        copyCurr = copyCurr.next;
	    }
	 
	    return copy;
	}
	
	/*original list is 1->2->3->4->null, insert 1,2,3,4 in this list, so it will be 1->1->2->2->3->3->4->4->null , v represents random pointer.
	                   v  v  v  v                                                   v     v     v     v
	                   3  1  3  2                                                   3     1     3     2
	                   
	                   *so the logic will be nCurr.next.random = nCurr.random.next, for example, take first node 1, 1 next is 1 and it's random will be random of next of 1
	                   *random of 1 is 3 and next of 3 is 3 
	                   *
	                   *
	                   */
	public static Node cloneNoExtraSpace(Node n) {
	    if (n == null) return n;
	 
	    Node nCurr = n;
	    while (nCurr != null) {
	        Node temp = new Node();
	        temp.data = nCurr.data;
	        temp.next = nCurr.next;
	        nCurr.next = temp;
	        nCurr = nCurr.next.next;
	    }
	 
	    nCurr = n;
	    while (nCurr != null) {
	        nCurr.next.random = nCurr.random.next;
	        nCurr = nCurr.next.next;
	    }
	 
	    Node copy = n.next; 
	    nCurr = n;
	    while (nCurr.next != null) {
	        Node tmp = nCurr.next;
	        nCurr.next = nCurr.next.next;
	        nCurr = tmp;
	    }
	 
	    return copy;
	}
	
	
	private static class Node<T>{
		private T data;
		private Node next;
		private Node random;
		
		public Node(){
			
		}
		
		public Node(T data){
			this.data=data;
			this.next=null;
			this.random=null;
		}

		@Override
		public String toString() {
			return "[prev=" + getNullOrValue(this.random) + "][data="
					+ getNullOrValue(this) + "][next="
					+ getNullOrValue(this.next) + "]";
		}

		private String getNullOrValue(Node<T> node) {
			return (node != null && node.data != null ? node.data : "null")
					.toString();
		}
		
	}

}
