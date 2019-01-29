package study_20190129;

import java.util.Arrays;
import java.util.Random; 

class test_05 {	 
	  private static void swap(int[] array, int i, int j) {
	       int temp = array[i];
	       array[i] = array[j];
	       array[j] = temp;
	  }
   
	  public static void main(String[] args) {
			int[] arr = new int[100];
			for (int i = 0; i<arr.length; i++) {
				arr[i] = i;
			}
			
			int count = arr.length;
	        Random random = new Random();
		 	
	        for (int i = 1; i < count; i++) {
	        	int j = random.nextInt(i+1);
	            swap(arr, i, j);
	        }
	        
	        System.out.println(Arrays.toString(arr));
	  }
}