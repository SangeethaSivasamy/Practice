/**
 * 
 */
package com.subrat.recursion;

/**
 * @author sparida
 *
 */
public class TowersOfHanoi {
	
	int n=6;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TowersOfHanoi towers = new TowersOfHanoi();
		towers.move(5,1,3);

	}

	private void move(int n, int startPole, int endPole) {
		if (n== 0){
		      return; 
		    }
		    int intermediatePole = 6 - startPole - endPole;
		    move(n-1, startPole, intermediatePole);
		    System.out.println("Move " +n + " from " + startPole + " to " +endPole);
		    move(n-1, intermediatePole, endPole);
		
	}

}
