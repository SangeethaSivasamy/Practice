/**
 * 
 */

/**
 * @author sparida
 *}
 *
 *
 *
 */
public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i <= 10; i++) {
			System.out.println(fibonacci.fib(i));
		}
		//int no =fibonacci.fib(5);
		//System.out.println(no);

	}

	private int fib(int i) {
		if(i==0 || i==1){
			return i;
		}
		return fib(i-2)+fib(i-1);
		
		
	}

}
