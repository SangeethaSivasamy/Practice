/**
 * 
 */
package com.subrat.stack;

import java.util.Stack;

/**
 * @author sparida
 *
 */
public class SortAStack {
	
	public Stack<Integer> sort(Stack<Integer> stack) {
	    if (stack == null || stack.isEmpty()) return stack;
	 
	    Stack<Integer> newStack = new Stack<Integer>();
	    newStack.push(stack.pop());
	    while (!stack.isEmpty()) {
	        int temp = stack.pop();
	        while (!newStack.isEmpty() && temp > newStack.peek()) {
	            stack.push(newStack.pop());
	        }
	        newStack.push(temp);
	    }
	    return newStack;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortAStack sortAStack = new SortAStack();
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(11);
		stack.push(3);
		stack.push(9);
		stack.push(10);
		stack.push(6);
		Stack<Integer> result =sortAStack.sort(stack);
		while(!result.isEmpty()){
			System.out.print(result.pop()+",");
		}

	}

}
