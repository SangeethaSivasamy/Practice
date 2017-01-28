/**
 * 
 */
package com.subrat.recursion;

/**
 * @author sparida
 *
 */
public class DoublePower {
	
	private int ipow(int base, int exp)
	{
	    int result = 1;
	    while (exp != 0)
	    {
	        if ((exp & 1) == 1)
	            result *= base;
	        exp >>= 1;
	        base *= base;
	    }

	    return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublePower doublePower = new DoublePower();
		Integer result = doublePower.ipow(2, 3);
		System.out.println(result);
	}

}
