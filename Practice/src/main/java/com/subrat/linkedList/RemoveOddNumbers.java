/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class RemoveOddNumbers {
	
	private LinkedList head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		RemoveOddNumbers removeOddNumbers = new RemoveOddNumbers();
		removeOddNumbers.head = new LinkedList(2);
		LinkedList node2 = new LinkedList(1);
		LinkedList node3 = new LinkedList(4);
		LinkedList node4 = new LinkedList(6);
		LinkedList node5 = new LinkedList(3);
		LinkedList node6 = new LinkedList(5);
		removeOddNumbers.head.next=node2;
		removeOddNumbers.head.next.next=node3;
		removeOddNumbers.head.next.next.next=node4;
		removeOddNumbers.head.next.next.next.next=node5;
		removeOddNumbers.head.next.next.next.next.next=node6;
		print(removeOddNumbers.head);
		LinkedList node = removeOddNumbers.remove(removeOddNumbers.head);
		System.out.println();
		print(node);
	}
	
	private static void print(LinkedList node) {
		if(node==null){
			return;
		}
		while(node!=null){
			System.out.print(node.data+"->");
			node = node.next;
		}
		System.out.print("null");
		
	}

	private LinkedList remove(LinkedList head) {
		if(head==null){
			return null;
		}
		Integer size = sizeOfList(head);
		LinkedList curr=head;
		LinkedList pre=null;
		while(curr !=null ){
			if(curr.data % 2 ==0){
				pre=curr;
				curr=curr.next;
			}else{
				pre.next=curr.next;
				curr=curr.next;
			}
		}
		return head;
	}

	private Integer sizeOfList(LinkedList head) {
		if(head==null){
			return 0;
		}
		int count =1;
		while(head.next!=null){
			count++;
			head=head.next;
		}
		return count;
	}

	private static class LinkedList{
		Integer data;
		LinkedList next;
		
		private LinkedList(Integer data){
			this.data=data;
			
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public LinkedList getNext() {
			return next;
		}

		public void setNext(LinkedList next) {
			this.next = next;
		}
		
		
		
	}

}
