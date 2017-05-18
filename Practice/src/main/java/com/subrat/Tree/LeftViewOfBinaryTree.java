package com.subrat.Tree;
/*
 * Given a binary tree, print the values of nodes which would be present in left view of binary tree. A node will be in the left-view if it is the left-most 
node at its level (imagine level order traversal). For example,     

                1
          2             3
      4      5       6  
        8              9
          10

In the above tree, 
node 1 is left-most node for level 0.
node 2 is left-most node for level 1.
node 4 is left-most node for level 2.
node 8 is left-most node for level 3.
node 10 is left-most node for level 4.
               
And therefore left view for this tree is 1,2,4,8,10
 */

import java.util.LinkedList;

public class LeftViewOfBinaryTree {
	class QueueNode
    {
        TreeNode node;
        int level;
         
        QueueNode(TreeNode node, int level)
        {
            this.node = node;
            this.level = level;
        }
    }
	class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int val;
     
        public TreeNode(int x)
        {
            this.val = x;
        }
    }
	TreeNode root;
	 
    
    /*
                            1
                      2             3
                  4      5       6  
                    8              9
                      10
    */
	private TreeNode createTree()
    {
        this.root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(8);
        TreeNode n7   = new TreeNode(9);
        TreeNode n8   = new TreeNode(10);
         
        root.left  = n1;
        root.right = n2;
         
        n1.left  = n3;
        n1.right = n4;
         
        n2.left  = n5;
         
        n3.right = n6;
         
        n5.right = n7;
         
        n6.right = n8;
         
        return root;
    }
 
 
    int maxLevelSoFar = -1;
    public void printLeftViewLevelOrder(TreeNode currentNode)
    {
        if (currentNode == null) return;
         
        LinkedList<QueueNode> queue = new LinkedList();
         
        queue.add(new QueueNode(currentNode, 0));
         
        while (!queue.isEmpty())
        {
            QueueNode queueEntry = queue.remove();
            if (queueEntry.level > maxLevelSoFar)
            {
                maxLevelSoFar = queueEntry.level;
                System.out.println(queueEntry.node.val);
            }
             
            if (queueEntry.node.left != null)
                queue.add(new QueueNode(queueEntry.node.left, queueEntry.level + 1));
 
            if (queueEntry.node.right != null)
                queue.add(new QueueNode(queueEntry.node.right, queueEntry.level + 1));
        }
         
    }
    public void printLeftView(TreeNode currentNode, int currentLevel)
    {
        if (currentNode == null) 
        	return;
         
        if (currentLevel > maxLevelSoFar)
        {
            System.out.println(currentNode.val);
            maxLevelSoFar = currentLevel;
        }
         
        printLeftView(currentNode.left, currentLevel + 1);
        printLeftView(currentNode.right, currentLevel + 1);
 
    }
    public static void main(String[] args)
    {
        LeftViewOfBinaryTree tree = new LeftViewOfBinaryTree();
         
        tree.createTree();
         
        tree.printLeftView(tree.root, 0);
         
        // tree.printLeftViewLevelOrder(tree.root);
    }

}
