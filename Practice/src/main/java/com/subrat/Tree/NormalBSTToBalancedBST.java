/**
 * 
 */
package com.subrat.Tree;

import java.util.Vector;

/**
 * @author sparida
 * 
 *         http://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/
 * 
 *         An Efficient Solution can construct balanced BST in O(n) time with
 *         minimum possible height. Below are steps.
 * 
 *         Traverse given BST in inorder and store result in an array. This step
 *         takes O(n) time. Note that this array would be sorted as inorder
 *         traversal of BST always produces sorted sequence. Build a balanced
 *         BST from the above created sorted array using the recursive approach
 *         discussed here. This step also takes O(n) time as we traverse every
 *         element exactly once and processing an element takes O(1) time.
 * 
 *         Input: 30 / 20 / 10 Output: 20 / \ 10 30
 * 
 * 
 *         Input: 4 / 3 / 2 / 1 Output: 3 3 2 / \ / \ / \ 1 4 OR 2 4 OR 1 3 OR
 *         .. \ / \ 2 1 4
 *
 * 
 */
public class NormalBSTToBalancedBST {

	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	static class Node {
		int data;
		Node left, right;

		public Node(int data) {
			this.data = data;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		/*
		 * This function traverse the skewed binary tree and stores its nodes
		 * pointers in vector nodes[]
		 */
		void storeBSTNodes(Node root, Vector<Node> nodes) {
			// Base case
			if (root == null)
				return;

			// Store nodes in Inorder (which is sorted
			// order for BST)
			storeBSTNodes(root.left, nodes);
			nodes.add(root);
			storeBSTNodes(root.right, nodes);
		}

		/* Recursive function to construct binary tree */
		Node buildTreeUtil(Vector<Node> nodes, int start, int end) {
			// base case
			if (start > end)
				return null;

			/* Get the middle element and make it root */
			int mid = (start + end) / 2;
			Node node = nodes.get(mid);

			/*
			 * Using index in Inorder traversal, construct left and right
			 * subtress
			 */
			node.left = buildTreeUtil(nodes, start, mid - 1);
			node.right = buildTreeUtil(nodes, mid + 1, end);

			return node;
		}

		// This functions converts an unbalanced BST to
		// a balanced BST
		Node buildTree(Node root) {
			// Store nodes of given BST in sorted order
			Vector<Node> nodes = new Vector<Node>();
			storeBSTNodes(root, nodes);

			// Constucts BST from nodes[]
			int n = nodes.size();
			return buildTreeUtil(nodes, 0, n - 1);
		}

		/* Function to do preorder traversal of tree */
		void preOrder(Node node) {
			if (node == null)
				return;
			System.out.print(node.data + " ");
			preOrder(node.left);
			preOrder(node.right);
		}

		public static void main(String[] args) {
			/* Constructed skewed binary tree is
            10
           /
          8
         /
        7
       /
      6
     /
    5   */
			BinaryTree tree = new BinaryTree();
			tree.root = new Node(10);
			tree.root.left = new Node(8);
			tree.root.left.left = new Node(7);
			tree.root.left.left.left = new Node(6);
			tree.root.left.left.left.left = new Node(5);

			tree.root = tree.buildTree(tree.root);
			System.out.println("Preorder traversal of balanced BST is :");
			tree.preOrder(tree.root);

		}

	}
}
