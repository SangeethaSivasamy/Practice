/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
class Node{
	public int data;
	public Node next;
	//public Node random;
	public Node random;
	public Node(int data){
		this.data = data;
		this.next = null;
		//this.random=null;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
	
}
