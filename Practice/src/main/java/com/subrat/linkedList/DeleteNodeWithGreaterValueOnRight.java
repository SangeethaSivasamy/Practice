/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 * http://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 * The list 12->15->10->11->5->6->2->3->NULL should be changed to 15->11->6->3->NULL. 
 * Note that 12, 10, 5 and 2 have been deleted because there is a greater value on the right side.
 * 
 * 1. Reverse the list.
   2. Traverse the reversed list. Keep max till now. If next node < max, then delete the next node, otherwise max = next node. 
   3. Reverse the list again to retain the original order. 
   
   
   Time Complexity: O(n)
 *
 */
public class DeleteNodeWithGreaterValueOnRight {
	
	private static Node head;
	private Integer maxFound=Integer.MIN_VALUE;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DeleteNodeWithGreaterValueOnRight obj = new DeleteNodeWithGreaterValueOnRight();
		obj.head=new Node(12);
		obj.head.next=new Node(15);
		obj.head.next.next=new Node(10);
		obj.head.next.next.next=new Node(11);
		obj.head.next.next.next.next=new Node(5);
		obj.head.next.next.next.next.next=new Node(6);
		obj.head.next.next.next.next.next.next=new Node(2);
		obj.head.next.next.next.next.next.next.next=new Node(3);
		Node node = obj.deleteNodes(head);
		print(node);
	}
	
	private static void print(Node node) {
		if(node==null){
			return;
		}
		while(node!=null){
			System.out.println(node.data);
			node=node.next;
		}
		
	}
//12->15->10->11->5->6->2->3
	private Node deleteNodes(Node head){
        if(head == null){
            return null;
        }
        Node nextNode = deleteNodes(head.next);
        if(head.data > maxFound){
            maxFound = head.data;
        }
        if(maxFound > head.data){
            return nextNode;
        }
        head.next = nextNode;
        return head;
    }
	
	private static class Node{
		int data;
		Node next;
		
		public Node(int data){
			this.data=data;
		}

		public int getData() {
			return data;
		}

		public void setData(int data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		
	}

}
