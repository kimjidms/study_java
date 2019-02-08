package study_20190208;

import java.io.File;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

class study_10 {
	public static void main(String[] args) {
		 ForkJoinPool pool = (ForkJoinPool) Executors
				 .newWorkStealingPool();
		 
		 FileSizeTask sizeTask = new FileSizeTask(new File("."));
		 ForkJoinTask<Long> task = pool.submit(sizeTask);
	
		 long total = task.join();
		 System.out.println("Total size: " + total);
		 
		 long total2 = new FileSizeTask(new File(".")).fork().join();
		 System.out.println("Total size: " + total2);
		 // 198456
		 // 198456
	} 
	
//	public static void main(String[] args) {
//		long total = new FileSizeTask(new File(".")).fork().join();
//		System.out.println("Total size: " + total);
//	}
}

// 198012
// 197732 