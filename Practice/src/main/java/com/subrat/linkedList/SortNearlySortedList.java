/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 * 
 *  Given a linklist which has individual sorted componenets sort the entire list
5	 e.g 1-2-6-8-4-5-10-7-9
6	 Here 1,2,6,8 are sorted, 4,5,10 are sorted and 7,9 are sorted
 *
 */
public class SortNearlySortedList {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortNearlySortedList obj = new SortNearlySortedList();
		obj.head=new Node(1);
		obj.head.next=new Node(2);
		obj.head.next.next=new Node(6);
		obj.head.next.next.next=new Node(8);
		
		obj.head.next.next.next.next=new Node(4);
		obj.head.next.next.next.next.next=new Node(5);
		obj.head.next.next.next.next.next.next=new Node(10);
		
		obj.head.next.next.next.next.next.next.next=new Node(7);
		obj.head.next.next.next.next.next.next.next.next=new Node(9);
		
		head=obj.sort(head);
		print(head);

	}
	
	private static void print(Node head) {
		Node curr=head;
		while(curr!=null){
			System.out.println(curr.data);
			curr=curr.next;
		}
		
	}
//1-2-6-8-4-5-10-7-9
	private Node sort(Node head) {
		Node result = null;
			        Node start = head;
			        while(head != null && head.next != null){
			            if(head.data < head.next.data){
			                head = head.next;
			            }else{
			                Node temp = head.next;
			                head.next = null;
			                result = mergeSort(result,start);
			                head = temp;
			                start = temp;
			            }
			        }
			        result = mergeSort(result,start);
			        return result;
	}
	
	private Node mergeSort(Node head1,Node head2){
			        if(head1 == null){
			            return head2;
			        }
			        if(head2 == null){
			            return head1;
			        }
			        if(head1.data <= head2.data){
			            head1.next = mergeSort(head1.next,head2);
			            return head1;
			        }else{
			            head2.next = mergeSort(head1,head2.next);
			            return head2;
			        }
			    }

	private static class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}

}
