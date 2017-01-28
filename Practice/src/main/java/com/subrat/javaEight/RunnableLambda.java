/**
 * 
 */
package com.subrat.javaEight;

/**
 * @author sparida
 *
 */
public class RunnableLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 3; i++) {
					System.out.println("Hello world from Thred {"+
							Thread.currentThread().getName()+
							"}");
					
				}
				
			}
		};*/
		
		Runnable runnableLambda = () -> {
			for (int i = 0; i < 3; i++) {
				System.out.println("Hello world from Thred {"+
						Thread.currentThread().getName()+
						"}");
				
			}
			
		};
		
		Thread t = new Thread(runnableLambda);
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
