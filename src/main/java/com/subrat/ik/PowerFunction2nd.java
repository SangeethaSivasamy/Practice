/**
 * 
 */
package com.subrat.ik;

/**
 * @author sparida
 *
 */
public class PowerFunction2nd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int base = 2;
		int power = 10;
		int result = powerFunction(base,power);
		System.out.println(result);

	}

	private static int powerFunction(int base, int exp) {
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
}
