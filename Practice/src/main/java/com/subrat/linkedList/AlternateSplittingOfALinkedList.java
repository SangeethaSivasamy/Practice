/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class AlternateSplittingOfALinkedList {
	
	private static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AlternateSplittingOfALinkedList alternateSplittingOfALinkedList = new AlternateSplittingOfALinkedList();
		alternateSplittingOfALinkedList.head=new Node(1);
		alternateSplittingOfALinkedList.head.nextNode=new Node(2);
		alternateSplittingOfALinkedList.head.nextNode.nextNode=new Node(3);
		alternateSplittingOfALinkedList.head.nextNode.nextNode.nextNode=new Node(4);
		alternateSplittingOfALinkedList.head.nextNode.nextNode.nextNode.nextNode=new Node(5);
		alternateSplittingOfALinkedList.head.nextNode.nextNode.nextNode.nextNode.nextNode=new Node(6);
		alternateSplittingOfALinkedList.displayList(head);
		Node node =alternateSplittingOfALinkedList.alternateSplit(head);
		alternateSplittingOfALinkedList.displayList(node);
	}
	
	private Node alternateSplit(Node head) {
		if(head==null){
			return null;
		}
		Node n1=head;
		Node temp=n1;
		Node n2=n1.nextNode;
		Node temp2=n2;
		while(n1!=null && n1.nextNode!=null){
			n1.nextNode=n1.nextNode.nextNode;
			if(n2.nextNode!=null){
				n2.nextNode=n2.nextNode.nextNode;
			}
			n1=n1.nextNode;
			n2=n2.nextNode;
		}
		AlternateSplittingOfALinkedList alternateSplittingOfALinkedList = new AlternateSplittingOfALinkedList();
		alternateSplittingOfALinkedList.displayList(temp2);
		return temp;
		
	}

	private void displayList(Node head) {
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

		@Override
		public String toString() {
			return "Node [data=" + data + ", nextNode=" + nextNode + "]";
		}
		
		
	}

}
