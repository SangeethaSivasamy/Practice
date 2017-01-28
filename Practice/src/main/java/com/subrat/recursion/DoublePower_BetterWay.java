/**
 * 
 */
package com.subrat.recursion;

/**
 * @author sparida
 *
 */
public class DoublePower_BetterWay {
	
	private double pow(double x, int n) {
              
        if(n==0) return 1;
        if(n==1) return x;
        if(n==-1) return 1/x;
        if(n==2) return x*x;
        
        if(n%2==0)
            return pow(pow(x, n/2),2);
        else{
            if(n>0)
                return x*pow(pow(x,n/2),2);
            else
                return 1/x*pow(pow(x,n/2),2);
        }
        
        
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DoublePower_BetterWay doublePower_BetterWay = new DoublePower_BetterWay();
		Double result = doublePower_BetterWay.pow(5, 3);
		System.out.println(result);
	}

}
