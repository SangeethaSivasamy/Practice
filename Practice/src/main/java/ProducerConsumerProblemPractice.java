import java.util.LinkedList;

public class ProducerConsumerProblemPractice {
	
	public static void main(String[] args) throws InterruptedException {
		
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
		
		t1.join();
		t2.join();
		
	}
	
	private static class PC{
		
		LinkedList<Integer> list = new LinkedList<>();
		Integer capacity = 4;
		
		private void produce() throws InterruptedException{
			int value=0;
			while(true){
				synchronized (this) {
					while(list.size()==capacity)
						wait();
					list.add(value++);
					notify();
					Thread.sleep(1000);
				}
			}
			
		}
		
		private void consume() throws InterruptedException{
			
			while(true){
				synchronized (this) {
					while(true){
						synchronized (this) {
							while(list.size()==0)
								wait();
							Integer value = list.removeFirst();
							notify();
							Thread.sleep(1000);
						}
					}
					
				}
			}
			
		}
	}

}
