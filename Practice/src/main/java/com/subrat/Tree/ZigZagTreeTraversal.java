/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author sparida
 * 
 * For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
   
   o/p----> [
  [3],
  [20,9],
  [15,7]
]
 *
 *use a queue to implement BFS. Each time when I poll a node, I add this node value to level. 
 *I use a variable zigzag to indicate whether add from left to right or right to left. If zigzag == false, it is from left to right; if zigzag == true, it is from right to left.
And from right to left just need to use ArrayList.add(0, value) method
 *
 */
public class ZigZagTreeTraversal {
	 private static Node rootNode;
	 
	 
	 public static void main(String[] args) {
	  
		 ZigZagTreeTraversal zigZagTreeTraversal = new ZigZagTreeTraversal();
		 zigZagTreeTraversal.rootNode = new Node(3);
		 Node left = new Node(9);
		 Node right = new Node(20);
		 Node leftOfRight = new Node(15);
		 Node rightOfright = new Node(7);
		 zigZagTreeTraversal.rootNode.setLeft(left);
		 zigZagTreeTraversal.rootNode.setRight(right);
		 zigZagTreeTraversal.rootNode.right.setLeft(leftOfRight);
		 zigZagTreeTraversal.rootNode.right.setRight(rightOfright);
		 print(rootNode);
		 System.out.println();
		 List<List<Integer>> listOfList = zigZagTreeTraversal.zigzagLevelOrder(rootNode);
		 for (List<Integer> list : listOfList) {
			for (Integer integer : list) {
				System.out.print(integer+",");
			}
		}
		 
	 }
	 
	 private List<List<Integer>> zigzagLevelOrder(Node rootNode) {
		 List<List<Integer>> res = new ArrayList<>();
		 if (rootNode == null) {
			 return res;
		 }
		 Queue<Node> queue = new LinkedList<>();
		 queue.add(rootNode);
		 boolean zigzag = false;
		 while (!queue.isEmpty()) {
		     List<Integer> level = new ArrayList<>();
		     int cnt = queue.size();
		     for (int i = 0; i < cnt; i++) {
		         Node node = queue.poll();
		         if (zigzag) {
		             level.add(0, node.data);
		         }
		         else {
		             level.add(node.data);
		         }
		         if (node.left != null) {
		             queue.add(node.left);
		         }
		         if (node.right != null) {
		             queue.add(node.right);
		         }
		     }
		     res.add(level);
		     zigzag = !zigzag;
		 }
		 return res;
	}



	private static void print(Node rootNode) {
		
		if(rootNode==null){
			return;
		}
		print(rootNode.left);
		System.out.print(rootNode.data+",");
		print(rootNode.right);
	}	
	 private static class Node{
		 private int data;
		 private Node left;
		 private Node right;
		 
		 public Node(int data) {
		  this.data=data;
		 }
		 
		 public int getData() {
		  return data;
		 }
		 public void setData(int data) {
		  this.data = data;
		 }
		 public Node getLeft() {
		  return left;
		 }
		 public void setLeft(Node left) {
		  this.left = left;
		 }
		 public Node getRight() {
		  return right;
		 }
		 public void setRight(Node right) {
		  this.right = right;
		 }
		}  
	}
