package study_20190211;

public class Accumulator {
	 public int sum(int... args) {
		 int sum = 0;
		 for (int i : args) sum += i;
		 return sum;
	 }
}