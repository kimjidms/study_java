package 김은지_ch16_2;

import java.util.concurrent.ForkJoinPool;

public class MergeSort {
	
	public static void sort(int[] arr) {
		 sort(arr, 0, arr.length);
	}
	
	public static void sort(int[] arr, int from, int to) {
		 sort(arr, from, to, new int[to - from], 0);
	}
	
	private static void sort(int[] arr, int from, int to, int[] tmp, int tmpStart) {
		
		 if ((to - from) <= 1) {
			 return;
		 }
		 
		 final int mid = (from + to) / 2;
		 sort(arr, from, mid, tmp, tmpStart); // 왼쪽 정렬
		 sort(arr, mid, to, tmp, tmpStart + (mid - from)); // 오른쪽 정렬
		 merge(arr, from, mid, to, tmp, tmpStart); // 병합
	}
	
	private static void merge(int[] arr, int from, int mid, int to, int[] tmp, int tmpStart) {
		
		final int size = to - from;
		
		 for (int left = from, right = mid, i = tmpStart; i < tmpStart + size; i++) {
			 if (left == mid) tmp[i] = arr[right++]; // 왼쪽 소진. 오른쪽만 남음
			 else if (right == to) tmp[i] = arr[left++]; // 오른쪽 소진. 왼쪽만 남음
			 else if (arr[left] > arr[right]) tmp[i] = arr[right++]; // 왼쪽 > 오른쪽
			 else tmp[i] = arr[left++]; // 왼쪽 <= 오른쪽
		 }
		 
		 System.arraycopy(tmp, tmpStart, arr, from, size);
	}

	public static void forkJoinSort(int[] arr, int threshold) {
		
		ForkJoinPool pool = new ForkJoinPool(); 
		ArraySizeTask sizeTask = new ArraySizeTask(arr);
		pool.invoke(sizeTask);
		
		// return null;
	}
}
	