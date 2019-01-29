package study_20190129;


class test_03 {
	public static void main(String[] args) {
		
		int[] score = { 76, 80, 55, 74, 81};
		
		int min = score[0];
		int max = score[0];
		
		for(int i = 0; i<score.length; i++) {
		  
			if(max<score[i]) {
				max = score[i];
		    }
					
		    if(min>score[i]) {
				min = score[i];
		    }
		}

		System.out.println(min);
		System.out.println(max);
	 }
}