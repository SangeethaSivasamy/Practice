/**
 * 
 */
package com.subrat.linkedList;

import java.util.Stack;

/**
 * @author sparida
 * 
 * push O(1), pop O(n)->worst case, O(1)-->if popstack is not empty, peek O(n)->worst case, O(1)-->if popstack is not empty. empty O(1)
 *
 */
public class QueueImplementationUsingStack {
	
	Stack<Integer> pushStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    // Push element x to the back of queue.
    public void push(int x) {
        pushStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        popStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(popStack.isEmpty()) {
            while(!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		QueueImplementationUsingStack queueImplementationUsingStack = new QueueImplementationUsingStack();
		queueImplementationUsingStack.push(1);
		queueImplementationUsingStack.push(2);
		queueImplementationUsingStack.push(3);
		//pop operation
		//peek operation
		
	}

}
