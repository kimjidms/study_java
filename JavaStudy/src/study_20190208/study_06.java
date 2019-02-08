package study_20190208;


public class study_06 {
	public static void main(String[] args) throws InterruptedException  {
		
		/*
		 * 1
		 */
		Thread t = new Thread() {
			public void run() {
				System.out.println(getName() + " is going to sleep");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {}
				 	System.out.println(getName() + " wake up");
				}
		 };
				 
		 t.start();		 
		 System.out.println(Thread.currentThread().getName()+ " is waiting for completing t");
		 // t.join();
		 System.out.println("t has done"); 
		 System.out.println(); 
		
		 
		/*
		 * 2
		 */
		Thread t1 = new Thread(() -> {
				 for (int i = 0;; i++) {
					 try {
						 Thread.sleep(500);
					 } catch (InterruptedException e) {}
					 System.out.println("count: " + i);
				 }
			 });
		
		 t1.setDaemon(true);
		 t1.start();
		 Thread.sleep(5000); 
	}
}