/**
 * 
 */
package com.subrat.linkedList;


import java.util.Stack;



/**
 * @author sparida
 *
 */
public class Solution {
	
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
		
		Solution solution = new Solution();
		solution.push(-5);
		solution.push(1);
		solution.push(0);
		solution.push(6);
		solution.push(-12);
		solution.pop();
		int no = solution.getMinInteger();
		System.out.println(no);

	}

}