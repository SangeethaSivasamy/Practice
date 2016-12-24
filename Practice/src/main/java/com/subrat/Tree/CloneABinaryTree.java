/**
 * 
 */
package com.subrat.Tree;

/**
 * @author sparida
 *
 */
public class CloneABinaryTree {
	
	 /*Again this question is more about figuring out the right traversal algorithm. Think how pre-order traversal works. We first visit the parent and then it's children. So pre-order traversal is the best way to achieve this. We will do it recursive way. The method is extension of class which is explained here. Here goes the code.
Make a clone of a given Binary tree.

template<typename T> NODE<T>* BST<T>::copyTree(NODE<T>* root)
{
    NODE<T>* copyNode = NULL;
    if (root)
    {
        copyNode = new NODE<T>();
        copyNode->data = root->data;
        copyNode->left = copyTree(root->left);
        copyNode->right = copyTree(root->right);
    }
    return copyNode;
}
As one can see this is pretty straight forward once you know which traversal algorithm to apply.*/
	 

}
