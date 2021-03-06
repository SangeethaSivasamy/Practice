/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class FindLoopandLoopLengthandBreakLoop {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FindLoopandLoopLengthandBreakLoop findLoopandLoopLengthandBreakLoop = new FindLoopandLoopLengthandBreakLoop();
		findLoopandLoopLengthandBreakLoop.addAtEnd(10);
		findLoopandLoopLengthandBreakLoop.addAtEnd(20);
		findLoopandLoopLengthandBreakLoop.addAtEnd(30);
		findLoopandLoopLengthandBreakLoop.addAtEnd(40);
		findLoopandLoopLengthandBreakLoop.addAtEnd(50);
		findLoopandLoopLengthandBreakLoop.addAtEnd(60);
		findLoopandLoopLengthandBreakLoop.addAtEnd(70);
		findLoopandLoopLengthandBreakLoop.display(head);
		findLoopandLoopLengthandBreakLoop.insertLoop(2);
		findLoopandLoopLengthandBreakLoop.checkLoop(head);
		
		

	}
	
	private void checkLoop(Node head) {
		Node firstPtr=head.next;
		Node secondPtr=head.next.next;
		
		while(firstPtr!=null){
			
			if(firstPtr==secondPtr){
				System.out.println("loop found");
				Integer loopLength=findTheLengthOfTheLoop(firstPtr,secondPtr);
				System.out.println(loopLength);
				breakTheLoop(firstPtr,secondPtr);
				//display(head);
				break;
			}else{
				firstPtr=firstPtr.next;
				secondPtr=secondPtr.next.next;
			}
		}
		
		
	}

	private void breakTheLoop(Node firstPtr, Node secondPtr) {
		firstPtr=firstPtr.next;
		while(firstPtr.next!=secondPtr){
			firstPtr=firstPtr.next;
		}
		firstPtr.next=null;
		System.out.println("loop breaks");
		FindLoopandLoopLengthandBreakLoop findLoopandLoopLengthandBreakLoop = new FindLoopandLoopLengthandBreakLoop();
		findLoopandLoopLengthandBreakLoop.display(head);
	}

	private Integer findTheLengthOfTheLoop(Node firstPtr, Node secondPtr) {
		firstPtr=firstPtr.next;
		int counter =1;
		while(firstPtr!=secondPtr){
			if(firstPtr!=secondPtr){
				firstPtr=firstPtr.next;
				counter++;
			}
		}
		//System.out.println(counter);
		return counter;
		
	}

	private void insertLoop(int index) {
		if(head==null){
			return;
		}
		Node endNode =head;
		while(endNode.next!=null){
			endNode=endNode.next;
		}
		Node curr=head;
		while(index!=0){
			curr=curr.next;
			index--;
		}
		endNode.next=curr;
		
	}

	private void display(Node head) {
		
		if(head==null){
			return;
		}
		while(head!=null){
		System.out.print(head.data+"->");
		head=head.next;
		}
		System.out.print("null");
		System.out.println();
	}

	private void addAtEnd(int data) {
		Node node = new Node(data);
		if(head==null){
			node.next=this.head;
			head=node;
		}else{
		Node curr=head;
		while(curr.next!=null){
			curr=curr.next;
		}
		curr.next=node;
		}
		
	}

	private static class Node{
		private Integer data;
		private Node next;
		
		public Node(Integer data){
			this.data=data;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + "]";
		}
		
		
	}

}
