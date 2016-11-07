/**
 * 
 */
package com.subrat.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sparida
 *
 */
public class TreeTraversal {

	static List<Integer> orderedList = new ArrayList<Integer>();

	public static void preOrderTraversal(TreeNode root) {

		if (root == null)

			return;

		orderedList.add(root.getData());

		preOrderTraversal(root.getLeftChild());

		preOrderTraversal(root.getRightChild());

	}

	public static void inOrderTraversal(TreeNode root) {

		if (root == null)

			return;

		inOrderTraversal(root.getLeftChild());

		orderedList.add(root.getData());

		inOrderTraversal(root.getRightChild());

	}

	public static void postOrderTraversal(TreeNode root) {

		if (root == null)

			return;

		postOrderTraversal(root.getLeftChild());

		postOrderTraversal(root.getRightChild());

		orderedList.add(root.getData());

	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(2);

		TreeNode left = new TreeNode(1);

		TreeNode right = new TreeNode(3);

		root.setLeftChild(left);

		root.setRightChild(right);

		System.out.print("\nPreorder traversal of 2 1 3: ");

		preOrderTraversal(root);

		for (Integer i : orderedList)

			System.out.print(i + " ");

		orderedList.clear();

		System.out.print("\nIneorder traversal of 2 1 3: ");

		inOrderTraversal(root);

		for (Integer i : orderedList)

			System.out.print(i + " ");

		orderedList.clear();

		System.out.print("\nPostorder traversal of 2 1 3: ");

		postOrderTraversal(root);

		for (Integer i : orderedList)

			System.out.print(i + " ");

	}
}