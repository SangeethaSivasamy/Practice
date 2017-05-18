/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class PrintNodesFromKDistanceFromRoot {
	
	private Node root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintNodesFromKDistanceFromRoot tree = new PrintNodesFromKDistanceFromRoot();
		/* Constructed binary tree is
        1
      /   \
     2     3
    /  \   /
   4    5 8 
*/
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);
		
		tree.printKDistant(tree.root, 2);
	}
	
	private void printKDistant(Node root, int k) {
		if(root==null){
			return;
		}
		if(k==0){
			System.out.println(root.data);
		}
		
		printKDistant(root.left, k-1);
		printKDistant(root.right, k-1);
		
	}

	static class Node{
		private Integer data;
		private Node left;
		private Node right;
		public Node(Integer data){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}

}
