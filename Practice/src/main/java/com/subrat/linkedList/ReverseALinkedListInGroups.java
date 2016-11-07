/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class ReverseALinkedListInGroups {

	private static Node head;

	public static void main(String[] args) {
		ReverseALinkedListInGroups reverseALinkedListInGroups = new ReverseALinkedListInGroups();
		reverseALinkedListInGroups.push(9);
		reverseALinkedListInGroups.push(8);
		reverseALinkedListInGroups.push(7);
		reverseALinkedListInGroups.push(6);
		reverseALinkedListInGroups.push(5);
		reverseALinkedListInGroups.push(4);
		reverseALinkedListInGroups.push(3);
		reverseALinkedListInGroups.push(2);
		reverseALinkedListInGroups.push(1);
		reverseALinkedListInGroups.printList(head);
		Node node = reverseALinkedListInGroups.reverseInGroups(head, 3);
		reverseALinkedListInGroups.printList(node);

	}

	private Node reverseInGroups(Node head, int k) {

		if (head == null) {
			return null;
		}

		int counter = 0;
		Node curr = null;
		Node next = head;
		Node pre = null;

		while (next != null && counter < k) {
			curr = next;
			next = curr.nextNode;
			curr.nextNode = pre;
			pre = curr;
			counter++;
		}

		if (next != null) {
			head.nextNode = reverseInGroups(next, k);
		}
		return pre;

	}

	private void printList(Node head) {
		if (head == null) {
			return;
		}

		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + ",");
			temp = temp.nextNode;

		}
		System.out.println();

	}

	private void push(int data) {
		Node newNode = new Node(data);
		newNode.nextNode = this.head;
		this.head = newNode;

	}

	class Node {

		private Integer data;
		private Node nextNode;

		public Node(int data) {
			this.data = data;
		}

	}

}
