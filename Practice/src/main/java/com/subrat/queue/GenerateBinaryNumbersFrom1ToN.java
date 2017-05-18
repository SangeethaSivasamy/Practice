/**
 * 
 */
package com.subrat.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author sparida
 *
 */
public class GenerateBinaryNumbersFrom1ToN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GenerateBinaryNumbersFrom1ToN obj = new GenerateBinaryNumbersFrom1ToN();
		int n=5;
		obj.generatePrintBinary(n);

	}

	private void generatePrintBinary(int n) {
		Queue<String> queue = new LinkedList<>();
		queue.add("1");
		while(n-- > 0){
			String s=queue.poll();
			System.out.println(s);
			String str = s;
			queue.add(new StringBuilder(s).append("0").toString());
			queue.add(new StringBuilder(str).append("1").toString());
		}
		
	}

}
