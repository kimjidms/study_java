package study_20190130;

class study_01 {
   public static void main(String[] args) {
		   Human bill = new Human();
		   bill.name = "Bill Gates";
		   bill.weight = 70.f;
		   bill.eat();
		   System.out.println(bill.name + " is " + bill.weight + "kg"); 
	   }
}

class Human {
	
	String name;
	int age;
	float height;
	float weight;
	
	void eat() { weight += 05f; }
	void diet() { weight -= 01f; }
	
}