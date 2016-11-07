/**
 * 
 */

/**
 * @author sparida
 *
 */
public class PrintFibonacciSeries {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PrintFibonacciSeries printFibonacciSeries = new PrintFibonacciSeries();
		printFibonacciSeries.printFibo(9);

	}

	private void printFibo(int i) {
		
		for (int j = 0; j <=i; j++) {
			System.out.print(getFibo(j)+",");
			
		}
		
	}

	private int getFibo(int j) {
		if(j==0){
			return 0;
		}
		if(j==1){
			return 1;
		}
		return getFibo(j-1)+getFibo(j-2);
	}

}
