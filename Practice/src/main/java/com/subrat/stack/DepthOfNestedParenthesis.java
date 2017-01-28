/**
 * 
 */
package com.subrat.stack;

/**
 * @author sparida
 * 
 * We are given a string having parenthesis like below
“( ((X)) (((Y))) )”
We need to find the maximum depth of balanced parenthesis, like 4 in above example. Since ‘Y’ is surrounded by 4 balanced parenthesis.
If parenthesis are unbalanced then return -1.
 *
 *S = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
Output : 4
S = "( p((q)) ((s)t) )";
Output : 3
S = "";
Output : 0
S = "b) (c) ()";
Output : -1 
S = "(b) ((c) ()"
Output : -1

A simple solution is to use a stack that keeps track of current open brackets.

2nd solution is as below.
1) Take two variables max and current_max, initialize both of them as 0.
2) Traverse the string, do following for every character
    a) If current character is ‘(’, increment current_max and 
       update max value if required.
    b) If character is ‘)’. Check if current_max is positive or
       not (this condition ensure that parenthesis are balanced). 
       If positive that means we previously had a ‘(’ character 
       so decrement current_max without worry. 
       If not positive then the parenthesis are not balanced. 
       Thus return -1. 
3) If current_max is not 0, then return -1 to ensure that the parenthesis
   are balanced. Else return max

 */
public class DepthOfNestedParenthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepthOfNestedParenthesis depthOfNestedParenthesis = new DepthOfNestedParenthesis();
		//Integer depth = depthOfNestedParenthesis.maxDepth("( ((X)) (((Y))) )");
		Integer depth = depthOfNestedParenthesis.maxDepth("(b) ((c) ()");
		System.out.println(depth);
	}

	private Integer maxDepth(String string) {
		int current_max = 0; // current count
	    int max = 0;    // overall maximum count
	    for (char ch : string.toCharArray()) {
			if(ch=='('){
				current_max++;
				if(current_max > max){
					max=current_max;
				}
			}else if(ch==')'){
					if(current_max>0){
						current_max--;
					}else{
						return -1;
					}
			}
				}	
	    if (current_max != 0)
	        return -1;
	 
	    return max;
	}
}


