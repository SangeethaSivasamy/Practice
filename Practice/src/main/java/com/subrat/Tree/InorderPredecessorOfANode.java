/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class InorderPredecessorOfANode {

	
	public static void main(String[] args) {
		
		InorderPredecessorOfANode bst = new InorderPredecessorOfANode();
		int [] a = {0,1,2,3,4,5,6,7,8,9,10};
        
        // BST is created using these values
        insertArrayIntoBST(bst, a, 0, a.length-1);
         
        System.out.println("--------------------------------------------");
         
        // print In-order and Pre-order traversals for this Tree 
        bst.printTree();
         
        System.out.println("--------------------------------------------");
         
        // find In-order successor of root Node.
        System.out.println("In-OrderSuccessor of root Node(5) is  "+bst.findinOrderPrintSuccessor(bst.root));   
    }	
	public class Node
    {
        int data;
        Node right;
        Node left;
        Node parent;
        Node(int data)
        {
            this.data = data;
        }
    }
     
    Node root;
     
    public void addNode(int data)
    {
        if (root == null)
        {
            System.out.println("root = "+data);
            root = new Node(data);
        }
        else
        {
            Node temp = new Node(data);
             
            Node current = this.root;
            Node prev = null;
            int lastBranch = 0; 
            while (current != null)
            {
                if (data < current.data)
                {
                    lastBranch = 0;
                    prev = current;
                    current = current.left;
                }
                else
                {
                    lastBranch = 1;
                    prev = current;
                    current = current.right;
                }
            }
             
            if (prev != null)
            {
                if (lastBranch == 0)
                {
                    prev.left = temp;
                    temp.parent = prev;
                }
                else
                {
                    prev.right = temp;
                    temp.parent = prev;
                }
            }
            else
            {
                System.out.println("something wrong");
            }
        }
         
    }
    public void inOrderPrint(Node root)
    {
        if (root == null) return;
         
         
        inOrderPrint(root.left);
        System.out.println(root.data);
        inOrderPrint(root.right);
         
    }
     
     
    public void preOrderPrint(Node root)
    {
        if (root == null) return;
         
        System.out.println(root.data);
        preOrderPrint(root.left);
        preOrderPrint(root.right);
         
    }
     
    public void printTree()
    {
        System.out.println("Pre-order traversal..");
        preOrderPrint(this.root);
         
        System.out.println("In-order traversal..");
        inOrderPrint(this.root);
    }
     
    public static void insertArrayIntoBST(InorderPredecessorOfANode bst, int [] a, int left, int right)
    {
        if (left > right)
        {
            return;
        }
         
        else
        {
            int mid = (left + right)/2;
            bst.addNode(a[mid]);
             
            insertArrayIntoBST(bst, a, left, mid - 1);
            insertArrayIntoBST(bst, a, mid + 1, right);
        }
         
    }
     
    private int doLeftSearch(Node root)
    {
        if (root.left == null) return root.data;
        int data = doLeftSearch(root.left);
        return data;
    }
     
    public int findinOrderPrintSuccessor(Node root)
    {
        int data = -1;
         
        if (root == null)
        {
            System.out.println("Wrong input");
        }
         
        if (root.right != null)
        {
            data = doLeftSearch(root.right);
        }
        else
        {
            while (true)
            {
                Node parent = root.parent;
                 
                if (parent == null) break;
                 
                if (parent.left == root)
                {
                    data = parent.data;
                    break;
                }
                else
                {
                    root = parent;
                }
            }
        }
        return data;
    }
}
