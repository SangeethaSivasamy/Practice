/**
 * 
 */
package com.subrat.linkedList;

/**
 * @author sparida
 *
 */
public class MaximumfromEachSubarray 
	{
	    private class AVLTreeNode 
	    {
	        int data;
	        AVLTreeNode left;
	        AVLTreeNode right;
	        int height;
	        
	        AVLTreeNode(int data)
	        {
	            this.data = data;
	            this.height = 1;
	        }
	    }
	    
	    AVLTreeNode root;
	    
	    public MaximumfromEachSubarray()
	    {
	
	    }
	    
	    private int getHeight(AVLTreeNode node)
	    {
	        if (node == null)
	            return 0;
	        
	        return node.height;
	    }
	    
	    private void updateHeight(AVLTreeNode node)
	    {
	        if (node == null) return;
	        
	        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	    }
	    
	    
	    private AVLTreeNode rotateRight(AVLTreeNode node)
	    {
	        if (node == null) return node;
	        
	        AVLTreeNode beta  = node.left;
	        
	        AVLTreeNode t2  = beta.right;
	        
	        beta.right = node;
	        node.left = t2;
        
	         
	        updateHeight(node);
	        
	         
	        updateHeight(beta);
	        
	        return beta;
	    }
	    
	    
	    private AVLTreeNode rotateLeft(AVLTreeNode node)
	    {
	        if (node == null) return node;
	        
	        AVLTreeNode beta  = node.right;
	        AVLTreeNode t2  = beta.left;
	        
	        beta.left = node;
	        node.right = t2;
	        
	         
	        updateHeight(node);
	        
	         
	        updateHeight(beta);
	        
	        return beta;
	    }
	    
	    
	    private int getBalance(AVLTreeNode node)
	    {
	        if (node == null)
	        {
	            return 0;
	        }
	        int balance;
	        
	        balance = getHeight(node.left) - getHeight(node.right);
	        
	        return balance;
	    }
    
	    
	    private int getMaxValue(AVLTreeNode node)
	    {
	         
	        if (node == null) return Integer.MIN_VALUE;
	        
         
	        if (node.right == null) return node.data;
	        
	        return getMaxValue(node.right);
	    }
	    
	    private int getMinValue(AVLTreeNode node)
	    {
	         
	        if (node == null) return Integer.MIN_VALUE;
        
	         
	        if (node.right == null) return node.data;
	        
	        return getMaxValue(node.left);
	    }
	    
	    private AVLTreeNode delete(AVLTreeNode node, int key)
	    {
	         
	        if (node == null) return null;
        
	        if (key < node.data)
	        {
	            node.left = delete(node.left, key);
	        }
	        else if (key > node.data)
	        {
	            node.right = delete(node.right, key);
	        }
	        
	        else  
	        {
	             
	            if (node.left == null)
	            {
	                node = node.right;
	            }
	            else if (node.right == null)
	            {
	                node = node.left;
	            }
	            
	             
	             
	             
	            else
	            {
	                int inorderSuccessorValue = getMinValue(node.right);
	                node.data = inorderSuccessorValue;
	                node.right = delete(node.right, inorderSuccessorValue);
	            }
	        }
	
	         
	        if (node == null)
	        {
	            return null;
	        }
	        
	         
	        updateHeight(node);
	        
	         
	        int balance = getBalance(node);
	        
	        if (balance > 1)  
	        {
	            if (getBalance(node.left) >= 0)  
	            {
	                node = rotateRight(node);
	            }
	            else  
	            {
	                node.left = rotateLeft(node.left);
	                node = rotateRight(node);
	            }
	        }
	        
	        else if (balance < -1)  
	        {
	            if (getBalance(node.right) <= 0)  
	            {
	                node = rotateLeft(node);
	            }
	            else  
	            {
	                node.right = rotateRight(node.right);
	                node = rotateLeft(node);
	            }
	        }
	        return node;
	    }
	    
	    
	    private AVLTreeNode insert(AVLTreeNode node, int key)
	    {
	         
	        if (node == null)
	        {
	            this.root =  new AVLTreeNode(key);
	            return this.root;
	        }
	        
	        if (key < node.data)
	        {
	            node.left = insert(node.left, key);
	        }
	        else if (key > node.data)
	        {
	            node.right = insert(node.right, key);
	        }
	        else
	        {
	            return node;
	        }
	        
	         
	        updateHeight(node);
	        
	         
	        int balance = getBalance(node);
	        
	        if (balance > 1)  
	        {
	            if (key < node.left.data)  
	            {
	                node = rotateRight(node);
	            }
	            else  
	            {
	                node.left = rotateLeft(node.left);
	                node = rotateRight(node);
	            }
	        }
	        
	        else if (balance < -1)  
	        {
	            if (key > node.right.data)  
	            {
	                node = rotateLeft(node);
	            }
	            else  
	            {
	                node.right = rotateRight(node.right);
	                node = rotateLeft(node);
	            }
	        }
	        return node;
	    }
	    
	    
	    public void insert(int key)
	    {
	        root = insert(this.root, key);
	        return;
	    }
	    
	    
	    public void delete(int key)
	    {
	        root = delete(this.root, key);
	        return;
	    }
	    
	
	    private void printMax(int[] array, int low, int high)
	    {
	        int maxValue = Integer.MIN_VALUE;
	        for (int i = low; i <= high; i++)
	        {
	            if (array[i] > maxValue)
	            {
	                maxValue = array[i];
	            }
	        }
	        
	        System.out.println(maxValue);
	    }
	    
	    public void simplePrintMaxfromEachSubarray(int[] array, int k)
	    {
	         
	        
	        int low = 0, high = low + k - 1;
	        
	        while (high < array.length)
	        {
	            printMax(array, low, high);
	            low  += 1;
	            high += 1;
	        }
	    }
	    
	    public void printMaxfromEachSubarray(int[] array, int k)
	    {
	         
	        for (int i = 0; i < k; i++)
	        {
	            insert(array[i]);
	        }
	         
	        System.out.println(getMaxValue(root));
	        
	         
	        for (int i = 0; i < array.length-k; i++)
	        {
	            delete(array[i]); 
	            insert(array[i+k]);
	            System.out.println(getMaxValue(root));
	        }
	    }
	
	    public static void main(String[] args)
	    {
	        MaximumfromEachSubarray solution = new MaximumfromEachSubarray();
	
	        int[] array = {4,2,12,34,23,35,44,55};
	        int k = 3;	        
	        System.out.println("Maximum elements from each sub-array of specified size are - " );
	        solution.printMaxfromEachSubarray(array, k);
	    }
	}