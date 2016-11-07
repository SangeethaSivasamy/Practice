/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class AlternateSplitPractice {
	
	private static Node headA=null;
	private static Node headB=null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AlternateSplitPractice alternateSplitPractice = new AlternateSplitPractice();
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next=new Node(1);
		node.next.next.next=new Node(2);
		node.next.next.next.next=new Node(1);
		node.next.next.next.next.next=new Node(2);
		alternateSplitPractice.display(node);
		alternateSplitPractice.alternateSplit(node);
		alternateSplitPractice.display(headA);
		alternateSplitPractice.display(headB);
	}

	private void alternateSplit(Node node) {
		if(node==null){
			return;
		}
		Node currNode=node;
		headA=currNode;
		headB=currNode.next;
		while(currNode!=null && currNode.next!=null){
			Node t=currNode.next;
			currNode.next=t.next;
			if(currNode!=null && currNode.next!=null){
				t.next=currNode.next.next;
			}else{
				t.next=null;
				return;
			}
			currNode=currNode.next;
		}
		
	}

	private void display(Node node) {
		if(node==null){
			return;
		}
		
		while(node!=null){
			System.out.print("->"+node.data);
			node = node.next;
		}
		System.out.println();
		
	}

}
