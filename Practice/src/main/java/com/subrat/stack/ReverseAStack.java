/**
 * 
 */
package com.subrat.stack;

import java.util.Stack;

/**
 * @author sparida
 * 
 * Given a stack, reverse the items without creating any additional data structures.

eg.

reverse(1->2->3) = 3->2->1
 *
 */
public class ReverseAStack {
	
	public Stack<Integer> reverse(Stack<Integer> stack) {
	    if (stack.isEmpty()) 
	    	return stack;
	    int temp = stack.pop();
	    reverse(stack);
	    insertAtBottom(stack, temp);
	    return stack;
	}
	 
	private void insertAtBottom(Stack<Integer> stack, int x) {
	    if (stack.isEmpty()) {
	       stack.push(x);
	       return;
	    }
	 
	    int temp = stack.pop();
	    insertAtBottom(stack, x);
	    stack.push(temp);
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReverseAStack reverseAStack = new ReverseAStack();
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		Stack<Integer> result = reverseAStack.reverse(stack);
		while(!result.isEmpty()){
			System.out.println(result.pop());
		}

	}

}
