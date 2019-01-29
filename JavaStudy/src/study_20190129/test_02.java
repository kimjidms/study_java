package study_20190129;


class test_02 {
	public static void main(String[] args) {
		
		int[] score = { 76, 80, 55, 74, 81};
		
		int sum = 0;
		float average;
		
		for (int value : score) {
			sum += value;
		}
		
		average = sum / score.length;
		
		System.out.println(sum);
		System.out.println(average);
	 }
}