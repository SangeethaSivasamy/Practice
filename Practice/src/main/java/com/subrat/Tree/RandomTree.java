/**
 * 
 */
package com.subrat.Tree;

import java.util.Random;

/**
 * @author sparida
 * Implement a binary tree with a method getRandomNode() that returns a random node.
 * http://www.byte-by-byte.com/randombinarytree/
 *
 */
public class RandomTree {

	
	public static void main(String[] args) {
		
		// Generates the tree:
        //        4
        //      /   \
        //     2     6
        //    / \   / \
        //   1   3 5   7
		
		root=new Node(4);
		root.left=new Node(2);
		root.right= new Node(6);
		root.left.left=new Node(1);
		root.left.right=new Node(3);
		root.right=new Node(6);
		root.right.left=new Node(5);
		root.right.right=new Node(7);
		
		RandomTree randomTree = new RandomTree();
		int result=randomTree.getRandomNode();
		
		System.out.println(result);
	}
	
	private static class Node {
        Node left;
        Node right;
        int val;
        int children;
        
        private Node(int val){
        	this.val=val;
        }
    }
	
	private static Node root;
    private Random rand;
    
    public RandomTree() {
        rand = new Random();
    }
    
    public int getRandomNode() {
        if (root == null) throw new NullPointerException();
        
        // This is an index of a node in the tree. Indices go in sorted order.
        int count = rand.nextInt(root.children + 1);
        return getRandomNode(root, count);
    }
    
 // Recursive method. Binary search through tree to find the index. We use 
    // the number of children to determine which direction to go
    private int getRandomNode(Node curr, int count) {
        if (count == children(curr.left)) return curr.val;
        if (count < children(curr.left)) return getRandomNode(curr.left, count);
        
        // The new index becomes the index of the same node but now within the
        // subtree rather than the whole tree
        return getRandomNode(curr.right, count - children(curr.left) - 1);
    }
    
    
 // Return the number of nodes in a given subtree
    private int children(Node n) {
        if (n == null) return 0;
        return n.children + 1;
    }

}
