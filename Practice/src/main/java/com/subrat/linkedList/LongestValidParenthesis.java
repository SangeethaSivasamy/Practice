/**
 * 
 */
package com.subrat.linkedList;

import java.util.Stack;

/**
 * @author sparida
 * 
 * Input: str = "(()()"

Initialize result as 0 and stack with one item -1.

For i = 0, str[0] = '(', we push 0 in stack

For i = 1, str[1] = '(', we push 1 in stack

For i = 2, str[2] = ')', currently stack has [-1, 0, 1], we pop
from the stack and the stack now is [-1, 0] and length of current
valid substring becomes 2 (we get this 2 by subtracting stack top 
from current index).
Since current length is more than current result, we update result.

For i = 3, str[3] = '(', we push again, stack is [-1, 0, 3].

For i = 4, str[4] = ')', we pop from the stack, stack becomes 
[-1, 0] and length of current valid substring becomes 4 (we get 
this 4 by subtracting stack top from current index). 
Since current length is more than current result, we update result. 
 *
 */
public class LongestValidParenthesis {
	
	private static int longestValidParentheses_1st_Way(String s) {
		
		int n = s.length();
		// Create a stack and push -1 as initial index to it.
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		// Initialize result
		Integer result = 0;
		// Traverse all characters of given string
		for (int i=0;i<n;i++) {
			// If opening bracket, push index of it
			if(s.charAt(i)=='('){
				stack.push(i);
			}else{// If closing bracket, i.e.,str[i] = ')'
				// Pop the previous opening bracket's index
				stack.pop();
				// Check if this length formed with base of
	            // current valid substring is more than max 
	            // so far
				if(!stack.isEmpty()){
					result = Math.max(result, i-stack.peek());
				}else{
					// If stack is empty. push current index as 
		            // base for next valid substring (if any)
					stack.push(i);
				}
				
			}
		}
		return result;
		
	}

	private static int longestValidParentheses(String s) {
		Stack<int[]> stack = new Stack<int[]>();
		int result = 0;
	 
		for(int i=0; i<=s.length()-1; i++){
			char c = s.charAt(i);
			if(c=='('){
				int[] a = {i,0};
				stack.push(a);
			}else{
				if(stack.empty()||stack.peek()[1]==1){
					int[] a = {i,1};
					stack.push(a);
				}else{
					stack.pop();
					int currentLen=0;
					if(stack.empty()){
						currentLen = i+1;
					}else{
						currentLen = i-stack.peek()[0];
					}
					result = Math.max(result, currentLen);
				}
			}
		}
	 
		return result;
	}
	
	public static void main(String[] args) {
		
		LongestValidParenthesis longestValidParenthesis = new LongestValidParenthesis();
		//Integer no = longestValidParenthesis.longestValidParentheses("()(())");
		Integer no = longestValidParenthesis.longestValidParentheses_1st_Way("()()");
		System.out.println(no);
	}

}
