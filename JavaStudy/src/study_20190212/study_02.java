package study_20190212;

public class study_02 {
	public interface Strategy {
		int operate(int a, int b);
	}

	public class Plus implements Strategy {
		public int operate(int a, int b) { return a + b; }
	}
		
	public class Minus implements Strategy {
		public int operate(int a, int b) { return a - b; }
	}

	public class Calculator {
		private Strategy strategy;
		
		public Calculator(Strategy strategy) { this.strategy = strategy; }
		public int calculate(int a, int b) {
			return strategy.operate(a, b);
		}
	}
	
	public class Client {
		 void method() {
			 Calculator c1 = new Calculator(new Plus());
			 System.out.println(c1.calculate(1, 2));
			 Calculator c2 = new Calculator(new Minus());
			 System.out.println(c2.calculate(1, 2));
		 }
	}
	
	
	
}
