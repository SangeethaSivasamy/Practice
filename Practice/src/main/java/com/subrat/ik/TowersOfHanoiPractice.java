/**
 * 
 */
package com.subrat.ik;

/**
 * @author sparida
 *
 */
public class TowersOfHanoiPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TowersOfHanoiPractice towers = new TowersOfHanoiPractice();
		towers.move(5,1,3);

	}

	private void move(int n, int startPole, int endPole) {
		if(n==0){
			return;
		}
		int intermediatePole = 6-startPole-endPole;
		move(n-1, startPole, intermediatePole);
		System.out.println("Moving "+n+" from "+startPole+" to "+endPole);
		move(n-1, intermediatePole, endPole);
		
	}

}
