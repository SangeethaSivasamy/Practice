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
public class RemoveDuplicatesInALinkedList {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Node n=new Node(1);
		Node n1=new Node(2);
		Node n2=new Node(2);
		Node n3=new Node(4);
		Node n4=new Node(3);
		Node n5=new Node(3);
		Node n6=new Node(2);
		n.nextNode=n1;
		n1.nextNode=n2;
		n2.nextNode=n3;
		n3.nextNode=n4;
		n4.nextNode=n5;
		n5.nextNode=n6;
		displayList(n);
		Node node =removeDuplicates(n);
		displayList(node);
	}
	
	private static Node removeDuplicates(Node n) {
		if(n==null){
			return null;
		}
		Map<Integer,Integer> map = new HashMap<>();
		Node curr=n.nextNode;
		Node pre=n;
		Node temp=null;
		map.put(n.data, 1);
		while(curr!=null){
			int data=curr.data;
			if(map.containsKey(data)){
				pre.nextNode=curr.nextNode;
				temp=curr;
				curr=curr.nextNode;
				temp.nextNode=null;
			}else{
				map.put(data, 1);
				pre=curr;
				curr=curr.nextNode;
				
			}
		}
		return n;
		
	}

	private static void displayList(Node n) {
		Node temp = n;
		while(temp!=null){
			System.out.print(temp.data);
			temp=temp.nextNode;
			if(temp!=null){
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
