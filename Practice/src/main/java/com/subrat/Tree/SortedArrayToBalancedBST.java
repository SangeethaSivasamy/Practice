/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class SortedArrayToBalancedBST {
	 
    public static void main(String[] args) {
        new SortedArrayToBalancedBST();
    }
 
    public SortedArrayToBalancedBST(){
        int[] arr = new int[]{1,2};
        Node balancedBST = sortedArrayToBST(arr, 0, arr.length-1);
        printTreeInOrder(balancedBST);
    }
 
    private Node sortedArrayToBST(int[] arr, int start, int end){
        if(start>end){
            return null;
        }
         
        int mid = start + (end-start)/2;
         
        Node temp = new Node(arr[mid]);
        temp.setLeft(sortedArrayToBST(arr, start, mid-1));
        temp.setRight(sortedArrayToBST(arr, mid+1, end));
         
        return temp;
    }
     
    private void printTreeInOrder(Node rootNode){
        if(rootNode==null)
            return;
        printTreeInOrder(rootNode.getLeft());
        System.out.print(rootNode.getData() + " ");
        printTreeInOrder(rootNode.getRight());
    }
    
    private static class Node{
    	private Integer data;
    	private Node left;
    	private Node right;
    	
    	public Node(Integer data){
    		this.data=data;
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

		@Override
		public String toString() {
			return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
    	
    }
}
