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
public class SequencePrinter {

	
	public static void main(String[] args) {
		
		Worker w1=new Worker();
		Worker w2=new Worker();
		Worker w3=new Worker();
		w1.setNext(w2);
		w2.setNext(w3);
		w3.setNext(w1);
		w1.accept(1);
		Thread t1=new Thread(w1,"Thread-1");
		Thread t2=new Thread(w2,"Thread-2");
		Thread t3=new Thread(w3,"Thread-3");
		t1.start();
		t2.start();
		t3.start();
		//w1.accept(1);
		

	}
	
	private static class Worker implements Runnable{
		
		BlockingQueue<Integer> q=new LinkedBlockingQueue<>();
		
		private Worker next;
		public void setNext(Worker t) {
			this.next = t;
		}
		
		public void accept(int i){
			q.add(i);
		}
		@Override
		public void run() {
			while(true){
				try {
					int i=q.take();
					System.out.println(i+"......"+Thread.currentThread().getName());
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
