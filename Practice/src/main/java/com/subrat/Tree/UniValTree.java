/**
 * 
 */
package com.subrat.Tree;



/**
 * @author sparida
 * 
 * https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
 * Given a binary tree, we need to count the number of unival subtrees (all nodes have same value).
 *
 */
public class UniValTree {
	
	private static TreeNode root;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UniValTree uniValTree =new UniValTree();
		uniValTree.root=new TreeNode(1);
		uniValTree.root.left=new TreeNode(2);
		uniValTree.root.left.left=new TreeNode(2);
		uniValTree.root.left.right=new TreeNode(2);
		uniValTree.root.left.left.left=new TreeNode(5);
		uniValTree.root.left.left.right=new TreeNode(5);
		uniValTree.root.right=new TreeNode(3);
		uniValTree.root.right.left=new TreeNode(3);
		uniValTree.root.right.right=new TreeNode(3);
		uniValTree.root.right.left.left=new TreeNode(4);
		uniValTree.root.right.left.right=new TreeNode(4);
		uniValTree.root.right.right.left=new TreeNode(3);
		uniValTree.root.right.right.right=new TreeNode(3);
		//Integer no =uniValTree.uniqueValueCount(root);
		Integer no =uniValTree.countUnivalSubtrees(root);
		System.out.println(no);

	}
	
	public int countUnivalSubtrees(TreeNode root) {
	      if(root == null) return 0;
	      int count = isUnivalue(root) ? 1 : 0;
	      return count + countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
	    }
	    
	    boolean isUnivalue(TreeNode node){
	      boolean b = true;
	      if(node.left != null){
	        b &= node.data == node.left.data;
	        b &= isUnivalue(node.left);
	      }
	      if(node.right != null){
	        b &= node.data == node.right.data;
	        b &= isUnivalue(node.right);
	      }
	      return b;
	    }
	    
	    /*int count = 0;
	    boolean all(TreeNode root, int val) {
	        if (root == null)
	            return true;
	        if (!all(root.left, root.val) | !all(root.right, root.val))
	            return false;
	        count++;
	        return root.val == val;
	    }
	    public int countUnivalSubtrees(TreeNode root) {
	        all(root, 0);
	        return count;
	    }*/
	
	/*public int countUnivalSubtrees(TreeNode root) {
        int[] arr = new int[1];
        postOrder(arr, root);
        return arr[0];
    }
    public boolean postOrder (int[] arr, TreeNode node) {
        if (node == null){
        	return true;
        }
        boolean left = postOrder(arr, node.left);
        boolean right = postOrder(arr, node.right);
        if (left && right) {
            if (node.left != null && node.left.data != node.data){
            	return false;
            }
            if (node.right != null && node.right.data != node.data){
            	return false;
            }
            arr[0]++;
            return true;
        }
        return false;
    }*/
	private Integer uniqueValueCount(TreeNode root) {
		int counter=0;
		uniqueValueCount(root,counter);
		return counter;
		
		
	}
	private void uniqueValueCount(TreeNode root, int counter) {
		
		if(root==null){
			return;
		}
		
		if(isUnique(root)){
			counter++;
		}else{
			uniqueValueCount(root.left,counter);
			uniqueValueCount(root.right, counter);
		}
		
		
	}
	private boolean isUnique(TreeNode root) {
		if(root==null){
			return true;
		}
		int key = root.data;
		return isUniqueUtil(root,key);
	
	}
	
	private boolean isUniqueUtil(TreeNode root, int key) {
		if(root==null){
			return true;
		}
		return root.data==key && isUniqueUtil(root.left, key) && isUniqueUtil(root.right, key);
	}

	private static class TreeNode{
		private Integer data;
		private TreeNode left;
		private TreeNode right;
		
		
		public TreeNode(Integer data){
			this.data=data;
		}


		public Integer getData() {
			return data;
		}


		public void setData(Integer data) {
			this.data = data;
		}


		public TreeNode getLeft() {
			return left;
		}


		public void setLeft(TreeNode left) {
			this.left = left;
		}


		public TreeNode getRight() {
			return right;
		}


		public void setRight(TreeNode right) {
			this.right = right;
		}


		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
		
		
	}

}
