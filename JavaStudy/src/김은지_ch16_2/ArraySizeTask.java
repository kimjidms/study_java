package 김은지_ch16_2;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ArraySizeTask extends RecursiveTask<Long>{

	private static final long serialVersionUID = 1L;
	private final int[] arr;
	 
	public ArraySizeTask(int[] arr) { this.arr = arr; }
	

	protected Long compute() {
		 if (arr.length != 1) return computeArray(arr);
		 long size = arr.length;
		 return size;
	 }
	 
	 private long computeArray(int[] arr) {
		 return Arrays.stream(arr).parallel()
//			 .map(ArraySizeTask::new)
//			 .map(ForkJoinTask::fork)
//			 .map(ForkJoinTask::join)
//			 .mapToLong(Long::longValue)
			 .sum();
	 } 
}
