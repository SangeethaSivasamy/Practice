/**
 * 
 */
package com.subrat.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author sparida
 *
 */
public class ValidParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ValidParenthesis validParenthesis = new ValidParenthesis();
		//boolean isValid = validParenthesis.isValid("[{()}]");
		boolean isValid = validParenthesis.isValid("[{(}]");
		//boolean isValid = validParenthesis.isValid("("( ( 1 + 2 ) * 3 )")");
		System.out.println(isValid);
	}

	private boolean isValid(String string) {
		if(string.isEmpty()){
			return true;
		}
		Map<Character,Character> map = new HashMap<>();
		map.put('(', ')');
		map.put('{', '}');
		map.put('[', ']');
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < string.length(); i++) {
			char ch = string.charAt(i);
			if(map.keySet().contains(ch)){
				stack.push(string.charAt(i));
			}
			else if(map.values().contains(ch)){
				if(!stack.isEmpty() && map.get(stack.peek())==ch){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		
		return stack.isEmpty();
	}

}
