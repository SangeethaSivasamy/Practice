/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class StackWithLinkListMiddleOperation {
	public static void main(String[] args) {
		//StackWithLinkListMiddleOperation obj = new StackWithLinkListMiddleOperation();
		stack s = new stack();
		s.push(50);
		s.push(40);
		s.push(30);
		s.push(20);
		s.push(10);
		s.push(70);
		System.out.println("mid item is :"+s.midItem());
	}
	static class stack{
		Node mid;
		Node top;
		int count;
		public stack(){
			top = null;
			mid = null;
			count = 0;
		}
		
		public void push(int d){
			Node temp = new Node(d);
			if(top == null){
				top = temp;
				mid = temp;
				count ++;
				return;
			}
			temp.next = top;
			top.pre = temp;
			top = temp;
			count ++;
			if(count%2 == 0){//go to next mid only in alternate turns
				mid = mid.pre;
				}
		}
		
		public int pop(){
			if(top == null) 
				return -1;
			Node temp = top;
			top = top.next;
			top.pre = null;
			count--;
			if(count % 2 == 1)
				mid = mid.pre;
			return temp.data;
		}
		public int peek(){
			if(top == null) return -1;
			return top.data;
		}
		public int midItem(){
			return mid.data;
		}
		public int delMid(){
			Node item = mid;
			mid = mid.pre;
			mid.next = item.next;
			mid.next.pre = mid;
			count--;
			return item.data;
		}
	}
	private static class Node{
		int data;
		Node next;
		Node pre;
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
		public Node getPre() {
			return pre;
		}
		public void setPre(Node pre) {
			this.pre = pre;
		}
		
	}

}
