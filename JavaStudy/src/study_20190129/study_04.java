package study_20190129;

class study_04 {
	public static void main(String[] args) {
		
		 int i1 = 10;
		 int i2 = 7;
		 System.out.println(i1 / i2);
		 
		 int big1 = 500_000;
		 int big2 = 900_000;
		 long bigger1 = big1 * big2; 
		 
		 // int * int
		 System.out.println(bigger1);
		 
		 // big1을 long으로 형변환후 곱셈. long * int
		 long bigger2 = (long) big1 * big2;
		 System.out.println(bigger2);
	 } 
}