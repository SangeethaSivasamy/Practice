/**
 * 
 */
package com.subrat.Tree;

import java.util.List;

/**
 * @author sparida
 *
 */
public class BinarySearchSum {

	private static Tree root;
	int sumTotal = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinarySearchSum binarySearchSum = new BinarySearchSum();
		Tree root = new Tree(new Integer(7));
		Tree left = new Tree(new Integer(3));
		Tree right = new Tree(new Integer(5));
		Tree leftOfRight = new Tree(new Integer(13));
		Tree rightOfright = new Tree(new Integer(12));
		root.setLeft(left);
		root.setRight(right);
		right.setLeft(leftOfRight);
		right.setRight(rightOfright);
		Integer result = binarySearchSum.sum(root);
		System.out.println(result);
	}

	private Integer sum(Tree root) {

		List<Integer> list = new java.util.ArrayList<Integer>();

		if (root == null) {
			return 0;
		} else {
			sum(root.getLeft());
			list.add(root.getData());
			sum(root.getRight());
		}

		for (Integer data : list) {
			sumTotal = sumTotal + data;
		}

		return sumTotal;

	}

	/*
	 * 7 / \ 3 5 / \ 13 12
	 */

	private static class Tree {
		private Integer data;
		private Tree left;
		private Tree right;

		public Tree(Integer data) {
			this.data = data;
		}

		public Integer getData() {
			return data;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		public Tree getLeft() {
			return left;
		}

		public void setLeft(Tree left) {
			this.left = left;
		}

		public Tree getRight() {
			return right;
		}

		public void setRight(Tree right) {
			this.right = right;
		}

		@Override
		public String toString() {
			return "Tree [data=" + data + ", left=" + left + ", right=" + right + "]";
		}

	}

}
