/**
 * 
 */
package com.subrat.linkedList.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class LRUCachePractice {
	
	private DoubleLinkedList pageList;
	private Map<Integer,Node> pageMap;
	private Integer capacity;
	
	public LRUCachePractice(int capacity){
		this.capacity=capacity;
		pageList = new DoubleLinkedList(capacity);
		pageMap = new HashMap<>();
	}

	private void accessPage(Integer pageNumber){
		if(pageNumber==null){
			return;
		}
		if(pageMap.containsKey(pageNumber)){
			Node pageNode = pageMap.get(pageNumber);
			if(pageNode!=null){
				pageList.movePageToHead(pageNode);
			}
		}else{
			if(pageList.getActualSize()==pageList.getSize()){
				pageMap.remove(pageList.getTail().getPageNumber());
			}
			Node pageNode=pageList.addPageToList(pageNumber);
			pageMap.put(pageNumber, pageNode);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	class DoubleLinkedList{
		
		private Node head;
		private Node tail;
		private int size;
		private int actualSize;

		public DoubleLinkedList(int capacity) {
			this.size=capacity;
			this.actualSize=0;
			
		}

		public Node getHead() {
			return head;
		}
		public void setHead(Node head) {
			this.head = head;
		}
		public Node getTail() {
			return tail;
		}
		public void setTail(Node tail) {
			this.tail = tail;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getActualSize() {
			return actualSize;
		}
		public void setActualSize(int actualSize) {
			this.actualSize = actualSize;
		}
		private void movePageToHead(Node pageNode){
			
		}
		
		private Node addPageToList(Integer pageNumber){
			return null;
			
		}
		
	}
	
	class Node{
		private Integer pageNumber;
		private Node tail;
		private Node head;
		public Integer getPageNumber() {
			return pageNumber;
		}
		public void setPageNumber(Integer pageNumber) {
			this.pageNumber = pageNumber;
		}
		public Node getTail() {
			return tail;
		}
		public void setTail(Node tail) {
			this.tail = tail;
		}
		public Node getHead() {
			return head;
		}
		public void setHead(Node head) {
			this.head = head;
		}
		
		
	}

}