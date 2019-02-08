package 김은지_ch16_2;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Consumer;

public class MergeSortTest {
  private static final int COUNT = 20_000_000;

  private static void execute(String name, int[] arr, Consumer<int[]> run) {
    long sum = 0;
    for (int i = 0; i < 5; i++) {
    	
      shuffle(arr);
      
      long start = System.currentTimeMillis();
      run.accept(arr);

      long end = System.currentTimeMillis();
      sum += (end - start);
    }
    System.out.printf("%s: %,d ms%n", name, sum / 5);
  }


	private static void shuffle(int[] arr) {
	    Random rnd = ThreadLocalRandom.current();
	    for (int i = arr.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      int a = arr[index];
	      arr[index] = arr[i];
	      arr[i] = a;
	    }
	}


	private static Consumer<int[]> forkJoinMergeSortRunner(int threshold) {
	    return arr -> MergeSort.forkJoinSort(arr, threshold);
	  }


    public static void main(String[] args) {
	  
	    int[] arr = new int[COUNT];
	    for (int i = 0; i < COUNT; i++) {
	      arr[i] = i;
	    }
	    execute("mergesort", arr, MergeSort::sort);
	
	    for (int i = 0; i < 10; i += 3) {
	      int threshold = (int) Math.pow(10, i);
	      execute(String.format("fork/join mergesort(%,d)", threshold), arr,
	          forkJoinMergeSortRunner(threshold));
	    }
	
	    execute("Arrays.sort", arr, Arrays::sort);
	    execute("Stream", arr, a -> {
	      int[] tmp = Arrays.stream(a).sorted().toArray();
	      System.arraycopy(tmp, 0, a, 0, tmp.length);
	    });
	
	    execute("Paralle stream", arr, a -> {
	      int[] tmp = Arrays.stream(a).parallel().sorted().toArray();
	      System.arraycopy(tmp, 0, a, 0, tmp.length);
	    });
  }
}