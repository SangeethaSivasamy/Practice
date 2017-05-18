package com.subrat.Tree;

public class PrintNonSiblingNodesBinaryTree {
    class TreeNode
    {
        TreeNode left;
        TreeNode right;
        int value;
     
        public TreeNode(int value)
        {
            this.value = value;
        }
    }
    TreeNode root;
    
    /*
                            0
                      1             2
                  3      4       5  
                    6              7
                      8
    */
    private TreeNode createTree()
    {
        this.root = new TreeNode(0);
        TreeNode n1   = new TreeNode(1);
        TreeNode n2   = new TreeNode(2);
        TreeNode n3   = new TreeNode(3);
        TreeNode n4   = new TreeNode(4);
        TreeNode n5   = new TreeNode(5);
        TreeNode n6   = new TreeNode(6);
        TreeNode n7   = new TreeNode(7);
        TreeNode n8   = new TreeNode(8);
         
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
    public void printNonSiblingNodes(TreeNode currentNode)
    {
        if (currentNode == null)
        {
            return;
        }
         
        if (currentNode.left == null && currentNode.right != null)
        {
            System.out.println(currentNode.right.value);
        }
        if (currentNode.right == null && currentNode.left != null)
        {
            System.out.println(currentNode.left.value);
        }
 
        printNonSiblingNodes(currentNode.left);
        printNonSiblingNodes(currentNode.right);
    }
    public static void main(String[] args)
    {
        PrintNonSiblingNodesBinaryTree tree = new PrintNonSiblingNodesBinaryTree();
 
        /*
                                0
                          1             2
                      3      4       5  
                        6              7
                          8
        */
 
        tree.createTree();
        tree.printNonSiblingNodes(tree.root);
    }
}