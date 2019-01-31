package study_20190130;

interface Shape {}
class Circle implements Shape {}
class Rectangle implements Shape {}


public class study_08 {
	 public static void main(String[] args) {
			 Shape s = new Circle(); // up casting
			 Circle c = (Circle) s; // down casting
			 print(new Rectangle());
			 print(s);
	 }
	 
	 static void print(Shape s) {
		 if (s instanceof Circle) {
			 Circle c = (Circle) s;
		 } else if (s instanceof Rectangle) {
			 Rectangle r = (Rectangle) s;
		 }
		 
		 if (s instanceof Object) { // 언제나 true
		 }
	}
}