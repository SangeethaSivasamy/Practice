/**
 * 
 */

/**
 * @author sparida
 *
 */
public class LunchFirstThreadUsingLambdaExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Runnable runnable = () -> {
			System.out.println("I am running in "+Thread.currentThread().getName());
		};
		
		Thread thread = new Thread(runnable);
		thread.setName("My_Thread");
		thread.start();

	}

}
