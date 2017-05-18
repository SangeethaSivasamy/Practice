/**
* 
*/
package com.subrat.Tree;

/**
 * @author sparida
 *         http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 *         http://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/
 * 
 *         Given two binary trees, check if the first tree is subtree of the
 *         second one. A subtree of a tree T is a tree S consisting of a node in
 *         T and all of its descendants in T. The subtree corresponding to the
 *         root node is the entire tree; the subtree corresponding to any other
 *         node is called a proper subtree.
 * 
 *         For example, in the following case, tree S is a subtree of tree T.
 * 
 *         Tree 2
          10  
        /    \ 
      4       6
       \
        30
 * 
 * 
 *         Tree 1
              26
            /   \
          10     3
        /    \     \
      4       6      3
       \
        30
 *
 */
public class OneTreeSubTreeOfAnotherTree {

	private Node root1,root2;
	

	public static void main(String[] args) {
		OneTreeSubTreeOfAnotherTree tree = new OneTreeSubTreeOfAnotherTree();

		// TREE 1
        /* Construct the following tree
              26
             /   \
            10     3
           /    \     \
          4      6      3
           \
            30  */

		tree.root1 = new Node(26);
		tree.root1.right = new Node(3);
		tree.root1.right.right = new Node(3);
		tree.root1.left = new Node(10);
		tree.root1.left.left = new Node(4);
		tree.root1.left.left.right = new Node(30);
		tree.root1.left.right = new Node(6);

		// TREE 2
        /* Construct the following tree
           10
         /    \
         4      6
          \
          30  */

		tree.root2 = new Node(10);
		tree.root2.right = new Node(6);
		tree.root2.left = new Node(4);
		tree.root2.left.right = new Node(30);

		if (tree.isSubtree(tree.root1, tree.root2))
			System.out.println("Tree 2 is subtree of Tree 1 ");
		else
			System.out.println("Tree 2 is not a subtree of Tree 1");
	}
	
	private boolean isSubtree(Node root1, Node root2) {
		if(root2==null){
			return true;
		}if(root1==null){
			return false;
		}if(isIdentical(root1,root2)){
			return true;
		}
		return isIdentical(root1.left,root2) || isIdentical(root1.right, root2);
	}

	private boolean isIdentical(Node root1, Node root2) {
		if(root1==null && root2==null){
			return true;
		}if(root1==null || root2==null){
			return false;
		}
		return root1.data==root2.data && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}

	private static class Node{
		private Integer data;
		private Node left;
		private Node right;
		public Node(Integer data){
			this.data = data;
			this.left=null;
			this.right=null;
		}
		public Integer getData() {
			return data;
		}
		public void setData(Integer data) {
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
