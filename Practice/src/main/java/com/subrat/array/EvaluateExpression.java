/**
 * 
 */
package com.subrat.array;

import java.util.Stack;

/**
 * @author sparida
 *
 */
public class EvaluateExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EvaluateExpression evaluateExpression = new EvaluateExpression();
		String[] tokens = new String[] { "2", "1", "+", "3", "*" };
		Integer result = evaluateExpression.evaluate(tokens);
		System.out.println(result);

	}

	private Integer evaluate(String[] tokens) {
		String token = "+-*/";
		Stack<Integer> stack = new Stack<>();
		for (String inputData : tokens) {
			if(!token.contains(inputData)){
				stack.push(Integer.parseInt(inputData));
			}else{
				Integer firstInput = stack.pop();
				Integer secondInput = stack.pop();
				switch (inputData) {
				case "+":
					stack.push(firstInput+secondInput);
					break;
					
				case "-":
					stack.push(secondInput-firstInput);
					break;
					
				case "*":
					stack.push(secondInput*firstInput);
					break;
					
				case "/":
					stack.push(secondInput/firstInput);
					break;

				default:
					break;
				}
			}
		}
		return stack.pop();
	}

}
