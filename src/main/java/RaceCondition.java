/**
 * 
 */

/**
 * @author sparida
 *
 */
public class RaceCondition {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		LongWrapper longWrapper = new LongWrapper(0l);
		Runnable runnable = () ->{
			for (int i = 0; i < 100; i++) {
				longWrapper.increamentValue();
			}
			
		};
		Thread[] threads = new Thread[100];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(runnable);
			threads[i].start();
		}
		
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		System.out.println(longWrapper.getValue());

	}

}
