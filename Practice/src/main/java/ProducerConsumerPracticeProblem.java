import java.util.LinkedList;

/**
 * 
 */

/**
 * @author sparida
 *
 */
public class ProducerConsumerPracticeProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PC pc = new PC();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					pc.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	private static class PC{
		
		LinkedList<Integer> list = new LinkedList<>();
		Integer capacity = 2;
		int value =0;

		public void produce() throws InterruptedException {
			while(true){
				synchronized (this) {
					while(list.size()==capacity)
						wait();
					list.add(value++);
					System.out.println(value);
					notify();
					Thread.sleep(1000);
				}
			}
			
		}

		public void consume() throws InterruptedException {
			
			while(true){
				synchronized (this) {
					while(list.size()==0)
						wait();
					Integer value = list.removeFirst();
					System.out.println(value);
					notify();
					Thread.sleep(1000);
					
				}
			}
			
			
		}
		
	}

}
