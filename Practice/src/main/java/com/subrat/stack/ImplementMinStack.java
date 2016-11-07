/**
 * 
 */
package com.subrat.stack;

import java.util.Stack;

/**
 * @author sparida
 *
 */
public class ImplementMinStack {
	
	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();
	
	private boolean push(int no){
		stack.push(no);
		if(minStack.isEmpty() || no<minStack.peek()){
			minStack.push(no);
			return true;
		}
		return false;
		
	}
	
	
	private boolean pop(){
		if(stack.isEmpty()){
			return false;
		}
		if(stack.peek()==minStack.peek()){
			stack.pop();
			minStack.pop();
			return true;
		}
		return false;
		
	}
	
	private Integer getMinInteger(){
		if(minStack.isEmpty()){
			return 0;
		}
		return minStack.peek();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ImplementMinStack implementMinStack = new ImplementMinStack();
		implementMinStack.push(-5);
		implementMinStack.push(1);
		implementMinStack.push(0);
		implementMinStack.push(6);
		implementMinStack.push(-12);
		implementMinStack.pop();
		int no = implementMinStack.getMinInteger();
		System.out.println(no);

	}

}
