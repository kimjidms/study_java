package study_20190208;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class study_09 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		Future<?> f = service.submit(() -> {
			System.out.println(Thread.currentThread().getName() + ": Hello");
		});
		
		Thread.sleep(5000);
		System.out.println(f.isDone());
				 
		Future<String> future = service.submit(() -> {
			System.out.println(Thread.currentThread().getName() + ": Hello again");
			return "Hello";
		});

		System.out.println(future.get());
		service.shutdown(); 
	}
}