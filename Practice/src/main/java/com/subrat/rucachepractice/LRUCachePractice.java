/**
 * 
 */
package com.subrat.rucachepractice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sparida
 *
 */
public class LRUCachePractice {
	
	private DoubleLinkedList pageList=null;
	private Map<Integer, Node> map=null;
	private Integer cacheSize;
	
	public LRUCachePractice(Integer DoubleLinkedList){
		this.cacheSize=cacheSize;
		pageList= new DoubleLinkedList(cacheSize);
		map = new HashMap<>();
	}
	
	public void accessPage(Integer pageNumber){
		Node pageNode=null;
		if(map.containsKey(pageNumber)){
			pageNode=map.get(pageNumber);
			pageList.moveNodeToHead(pageNode);
		}else{
			
			if(pageList.getCurrSize()==pageList.getSize()){
				map.remove(pageList.getTail().getPageNo());
			}else{
				pageNode=pageList.addPageToList(pageNumber);
				map.put(pageNumber, pageNode);
			}
			
		}
	}
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}

class DoubleLinkedList{
	
	private Node head;
	private Node tail;
	private final int size;
	private Integer currSize;
	
	public DoubleLinkedList(Integer size){
		this.size=size;
		currSize=0;
	}

	public Node addPageToList(Integer pageNumber) {
		
		return null;
	}

	public void moveNodeToHead(Node pageNode) {
		
		
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

	public Integer getCurrSize() {
		return currSize;
	}

	public void setCurrSize(Integer currSize) {
		this.currSize = currSize;
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		return "DoubleLinkedList [head=" + head + ", tail=" + tail + ", size=" + size + ", currSize=" + currSize + "]";
	}
	
	
	
	
}

class Node{
	private Integer pageNo;
	private Node pre;
	private Node next;
	
	public Node(Integer pageNo){
		this.pageNo=pageNo;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Node getPre() {
		return pre;
	}

	public void setPre(Node pre) {
		this.pre = pre;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Node [pageNo=" + pageNo + ", pre=" + pre + ", next=" + next + "]";
	}
	
}
