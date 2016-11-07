/**
 * 
 */
package com.subrat.recursion;

/**
 * @author sparida
 *
 */
public class FibonacciMemoization {
	
	private static int[] array=new int[26];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciMemoization fibonacciMemoization = new FibonacciMemoization();
		int i=25;
		Long before = System.currentTimeMillis();
		Integer no = fibonacciMemoization.calculateFibonacci(i);
		Long after = System.currentTimeMillis();
		System.out.println(no);
		//String timeTaken=(after-before).
		//System.out.println(no+" and time taken to calculate is:"+after-before);

	}

	private Integer calculateFibonacci(int no) {
		int fibValue = 0;
		if(no==0){
			return 0;
		}
		else if(no==1){
			return 1;
		}
		else if(array[no]!=0){
			return array[no];
		}else{
			fibValue = calculateFibonacci(no-1)+calculateFibonacci(no-2);
			array[no]=fibValue;
			return array[no];
		}
		
	}

}
