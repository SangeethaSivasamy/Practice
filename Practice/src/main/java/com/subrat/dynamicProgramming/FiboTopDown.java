/**
 * 
 */
package com.subrat.dynamicProgramming;

/**
 * @author sparida
 *
 */
public class FiboTopDown {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FiboTopDown fibo = new FiboTopDown();
		Integer value = fibo.calculateFobi(3);
		System.out.println(value);
	}

	private Integer calculateFobi(int no) {
		int[] fib = new int[no+1];
		if(no==0 || no==1){
			return no;
		}
		if(fib[no]!=0){
			return fib[no];
		}else{
			fib[no]=calculateFobi(no-1)+calculateFobi(no-2);
			return fib[no];
		}
	}

}
