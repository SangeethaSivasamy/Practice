/**
 * 
 */
package com.subrat.ik;

/**
 * @author sparida
 *
 */
public class PowerFunction {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int base = 2;
		int power = 10;
		Double value = powerFunction(base,power);
		System.out.println(value);

	}

	private static Double powerFunction(int base, int power) {
		Double result = 1d;
		if(power == 1){
			return (double) base;
		}
		if(power == 0){
			return 1d;
		}
		Double temp = powerFunction(base, power/2);
		if(power%2==0){
			return temp * temp;
		}else{
			return base * temp * temp;
		}
		
	}

}
