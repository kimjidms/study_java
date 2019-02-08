package study_20190208;

import java.io.IOException;

public class study_05 {
	public static void main(String[] args) throws IOException  {
	
		System.out.println(Thread.currentThread().getName()); 
		
		 new Thread( 
				 () -> System.out.println(Thread.currentThread().getName())).start();
		
		 new Thread() {
			 public void run() {
				 try {
					 System.out.println(getName() + " is sleepging");
					 Thread.sleep(4000); 
				 } catch (InterruptedException e) {
					 System.out.println(e); 
				 }
				 System.out.println(getName() + " wake up"); 
			 }
		 }.start();
	}
}
