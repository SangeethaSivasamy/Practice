/**
 * 
 */
package com.subrat.Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author sparida
 *
 */
public class BottomViewOfBinaryTree {
	 private NodeForBottomView rootNode=null;
	 Map<Integer, NodeForBottomView> map = new TreeMap<Integer, NodeForBottomView>();
	  
	 public static void main(String[] args) {
	  new BottomViewOfBinaryTree();
	 }
	 
	 public BottomViewOfBinaryTree(){
	  addNode(rootNode, 30); 
	  addNode(rootNode, 10); 
	  addNode(rootNode, 60); 
	  addNode(rootNode, 59); 
	  addNode(rootNode, 58); 
	  addNode(rootNode, 55); 
	  addNode(rootNode, 50); 
	   
	  printBottomView(rootNode);
	   
	  for (Map.Entry<Integer, NodeForBottomView> element : map.entrySet()) {
	   System.out.print(((NodeForBottomView)element.getValue()).getData() + " ");
	  }
	 }
	  
	 private void printBottomView(NodeForBottomView rootNode) {
	  if(rootNode==null)
	   return; 
	 
	   
	 
	  Queue<NodeForBottomView> queue = new LinkedList<NodeForBottomView>();
	  queue.add(rootNode);
	   
	  while(!queue.isEmpty()){
	   NodeForBottomView temp = (NodeForBottomView)queue.poll();
	    
	   int currentLevel = temp.getLevel();
	    
	   map.put(currentLevel, temp);
	    
	   if(temp.getLeftNode()!=null){
	    temp.getLeftNode().setLevel(currentLevel-1);
	    queue.add(temp.getLeftNode());
	   }
	    
	   if(temp.getRightNode()!=null){
	    temp.getRightNode().setLevel(currentLevel+1);
	    queue.add(temp.getRightNode());
	   }
	  }
	   
	 }
	 
	 private void addNode(NodeForBottomView rootNode, int data){
	  if(rootNode==null){
	   NodeForBottomView temp = new NodeForBottomView(data);
	   this.rootNode=temp;
	  }else{
	   addNodeInProperPlace(rootNode, data);
	  }
	 }
	 
	 private void addNodeInProperPlace(NodeForBottomView rootNode, int data){ 
	  if(data>rootNode.getData()){
	   if(rootNode.getRightNode()!=null){
	    addNode(rootNode.getRightNode(), data);
	   }else{
	    NodeForBottomView temp1 = new NodeForBottomView(data);
	    rootNode.setRightNode(temp1);
	   }
	  }else if(data<rootNode.getData()){
	   if(rootNode.getLeftNode()!=null){
	    addNode(rootNode.getLeftNode(), data);
	   }else{
	    NodeForBottomView temp1 = new NodeForBottomView(data);
	    rootNode.setLeftNode(temp1);
	   }
	  }
	 }
	 private static class NodeForBottomView{
		  
		 private int data;
		 private NodeForBottomView leftNode;
		 private NodeForBottomView rightNode;
		 private int level;
		  
		 public NodeForBottomView(int data) {
		  this.data = data;
		 }
		  
		 public int getData() {
		  return data;
		 }
		 public void setData(int data) {
		  this.data = data;
		 }
		 public NodeForBottomView getLeftNode() {
		  return leftNode;
		 }
		 public void setLeftNode(NodeForBottomView leftNode) {
		  this.leftNode = leftNode;
		 }
		 public NodeForBottomView getRightNode() {
		  return rightNode;
		 }
		 public void setRightNode(NodeForBottomView rightNode) {
		  this.rightNode = rightNode;
		 }
		 public int getLevel() {
		  return level;
		 }
		 public void setLevel(int level) {
		  this.level = level;
		 } 
		}
	}
