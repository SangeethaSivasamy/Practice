/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class BinaryTreeToDoubleyLinkedList {
	
	private Node root;
    
    public Node convertToDoublyLinkedList() {
        if (root == null) {
            return null;
        }
 
        root = convertToDoublyLinkedList(root);
 
        // Move to the leftmost node in the list
        while (root.getLeft() != null)
            root = root.getLeft();
  
        return root;
    }
 
    private Node convertToDoublyLinkedList(Node root) {
         
        if (root.getLeft() != null) {
            Node left = convertToDoublyLinkedList(root.getLeft());
            while (left.getRight() != null) {
                left = left.getRight();
            }
            left.setRight(root);
            root.setLeft(left);
        }
         
        if (root.getRight() != null) {
            Node right = convertToDoublyLinkedList(root.getRight());
            while (right.getLeft() != null) {
                right = right.getLeft();
            }
            right.setLeft(root);
            root.setRight(right);
        }
 
        return root;
    }
	 
	/*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     *
     */
    
    /*Output:
    	4 2 5 1 6 3 7 */
	
	public void createSampleTree() {
        root = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, new Node(6), new Node(7)));       
    }
	
	public static void main(String[] args) {
		BinaryTreeToDoubleyLinkedList tree = new BinaryTreeToDoubleyLinkedList();
        tree.createSampleTree();
        Node linkedList = tree.convertToDoublyLinkedList();
        printList(linkedList);
    }
 
    public static void printList(Node linkedList) {
        System.out.println("Output:");
        while(linkedList != null) {
            System.out.print(linkedList.getData() + " ");
            linkedList = linkedList.getRight();
        }
    }
    
    static class Node {
   	 
        private int data;
        private Node left;
        private Node right;
     
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
     
        public Node(int data) {
            this.data = data;
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

