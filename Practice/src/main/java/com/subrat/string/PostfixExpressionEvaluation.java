package com.subrat.string;

import java.util.Stack;

/**
 * 
 * 
 * Given an array of Strings, every string being either an operand or an operator,
 * in Reverse Polish Notation, find out the value of the expression.
 *
 * 
 */
public class PostfixExpressionEvaluation {
    public static int evalPostfixExpression(String[] op) {
         
        if(op.length == 1) {
            return Integer.parseInt(op[0]);
        }
         
        Stack<Integer> s = new Stack<Integer>();
        for(String exp : op) {
             
            Integer value = null;
            String operator = null;
            if((exp.charAt(0) >= '0' && exp.charAt(0) <= '9') ||
               (exp.charAt(0) == '-' && exp.length() > 1)) {
                value = Integer.parseInt(exp);
            } else {
                operator = exp;
            }
             
            if(operator != null) {
                Integer y = s.pop();
                Integer x = s.pop();
                 
                switch(operator) {
                    case "+" : value = x + y; break;
                    case "-" : value = x - y; break;
                    case "*" : value = x * y; break;
                    case "/" : value = x / y; break;
                }
            }
            s.push(value);
        }
        return s.pop();
    }
 
    public static void main(String[] args) {
        String[] op = {"5", "1", "2", "+", "4", "*", "+", "3", "-"};
        System.out.println("Value of the expression is " + evalPostfixExpression(op));
    }
}
