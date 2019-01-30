package study_20190130;

class Parent {
	 int value1 = 10;
	 void method1() { System.out.println("value1 = " + value1); }
}


class Child extends Parent {
	 int value2 = 20;
	 void method2() {
	 method1();
	 System.out.println("sum = " + (value1 + value2));
	 }
}
	
class study_06 {
	 public static void main(String[] args) {
		 
		 Parent p = new Parent();
		 p.method1();
		 
		 Child c = new Child();
		 c.method2();
		 c.method1(); // Parent에서 정의		 
	 }
}