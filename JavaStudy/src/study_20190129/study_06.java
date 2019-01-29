package study_20190129;

class study_06 {
	public static void main(String[] args) {
		
		int[] intArr = new int[100];
		
		for(int i=0; i<intArr.length; i++) {
			intArr[i] = i * i;
		}
		System.out.println("\n");
		
		for (int value : intArr) {
			System.out.println(value);
		}
		System.out.println("\n");
		
		for (int i = 0; i<intArr.length; i++) {
			int value = intArr[i];
			System.out.println(value);
		}
	 } 
}