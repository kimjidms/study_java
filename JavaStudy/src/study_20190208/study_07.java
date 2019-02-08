package study_20190208;

import java.util.Random;

public class study_07 {
	static class Counter {
      private int c = 0;
	  public void increment() {
	  int oldC = c;
		 
	  try {
		  Thread.sleep(new Random().nextInt(100));
		  } catch (InterruptedException e) {}
	  
	  c++;
	  
	  try {
		  Thread.sleep(new Random().nextInt(100));
	  } catch (InterruptedException e) {}
	  
	  System.out.println(oldC + " -> " + c);
	  }
    }
	
	public static void main(String[] args) {
		Counter c = new Counter();
		
		 Runnable r = () -> { while (c.c < 20) c.increment(); };
		 new Thread(r).start();
		 new Thread(r).start();  
	}	
}