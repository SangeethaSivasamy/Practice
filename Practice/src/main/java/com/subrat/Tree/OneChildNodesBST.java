package com.subrat.Tree;

/*http://www.ideserve.co.in/learn/check-if-all-internal-nodes-have-one-child-bst
 * 
 * 
 * Given preorder traversal array for a binary search tree(BST), without actually building the tree check if all internal nodes of BST have only one child.
For example, for the preorder array - {9, 8, 5, 7, 6} the BST would like the tree on the left hand side in below diagram. All its internal nodes have only one child. 
But for the preorder array - {8, 5, 4, 7, 6} the BST would be the tree shown on the right hand side in below diagram and as you can see node 5 has two children 
and for this case output returned should be 'false'.

*
*Method 1: For each element preorder[i] starting from i = 0, check if all elements appearing after preorder[i] are either less than or greater than preorder[i]. 
*If for preorder[i], thic conditions holds true then return true else return false. The time complexity for this method would be O(n^2). 


Method 2:  Now instead of traversing array from index 0, if we start traversing preorder array from index = (size Of preorderArray - 1) towards index = 0, 
and keep track of maximum and minimum elements seen so far(maxSoFar, minSoFar) then we can easily check if all elements appearing after preorder[i](elements from index i+1 to end) 
are less than or greater than preorder[i]. If all elements are less than preorder[i] then maxSoFar value must be less than preorder[i] and vice versa.
Please checkout function checkOneChildNodesBST(int[] preorder) in code snippet for implementation details. The time complexity of this algorithm is O(n) 
with O(1) auxiliary space usage.

*/

public class OneChildNodesBST 
{
    private int minimum(int a, int b)
    {
        if (a < b) return a;
        return b;
    }
 
    private int maximum(int a, int b)
    {
        if (a > b) return a;
        return b;
    }
 
    public boolean checkOneChildNodesBST(int[] preorder)
    {
        int maxSoFar = preorder[preorder.length - 1], minSoFar = preorder[preorder.length - 1];
         
        /*
         *  check if all elements in the sub-array from [i+1 to end] of the array 
         *  are less than current element - preorder[i]. If not, all these elements should
         *  be greater than the current element.  
         */
        for (int i = preorder.length - 2; i >= 0; i--)
        {
            if (!((preorder[i] < minSoFar) || (preorder[i] > maxSoFar))) 
            {
                return false;
            }
            maxSoFar = maximum(preorder[i], maxSoFar);
            minSoFar = minimum(preorder[i], minSoFar);
        }
        return true;
    }
 
    public static void main(String[] args)
    {
        OneChildNodesBST solution = new OneChildNodesBST();
         
        int[] preorderTree1 = {9,8,5,7,6};
        int[] preorderTree2 = {8,5,4,7,6};
         
        System.out.println("Check if evry internal node of this BST has only one child:\n" + solution.checkOneChildNodesBST(preorderTree1));
    }
}