package study_20190130;

class study_02 {
	
	 static int a; // static 변수 = 클래스 변수
	 int b; 
	 
	 void method() {
		 int c = a + b; 
		 System.out.println("a = " + a + ", b = " + b + ", c = " + c);
	 }
	 
	 public static void main(String[] args) {
		 study_02 v1 = new study_02();
		 v1.b = 10;
		 study_02 v2 = new study_02();
		 v2.b = 20;

		 study_02.a = 5;
		 v1.method();
		 v2.method();
	 } 
}