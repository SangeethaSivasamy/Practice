/**
 * 
 */
package com.subrat.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author sparida
 *
 */
public class PrintOddAndEven {

	
	public static void main(String[] args) {
		
		Worker w1=new Worker();
		Worker w2=new Worker();
		w1.setNext(w2);
		w2.setNext(w1);
		Thread t1=new Thread(w1,"odd");
		Thread t2=new Thread(w2,"even");
		t1.start();
		t2.start();
		w1.accept(1);
	}
	
	private static class Worker implements  Runnable {
		
		BlockingQueue<Integer> q = new LinkedBlockingQueue<>();
		
		private Worker next;
		
		private void setNext(Worker t){
			this.next=t;
		}
		
		private void accept(int i){
			q.add(i);
		}
		
		public void run() {
			while(true){
				try {
					int i=q.take();
					System.out.println(i+"...."+Thread.currentThread().getName());
					Thread.sleep(1000);
					if(next!=null){
						next.accept(i+1);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
