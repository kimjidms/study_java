package study_20190212;

import study_20190212.Logger.Level;

public class Client {
//	 private Listener l = event -> System.out.println("state changed: " + event);
//	 private StateHolder holder;
//	 
//	 void setHolder(StateHolder holder) {
//		 holder.addListener(l);
//		 this.holder = holder;
//	 }
//	 
//	 void method() {
//		 holder.setState(10);
//	 }

	 public static void main(String[] args) {
		 Logger logger = new InfoLogger()
			 .appendNext(new AlwaysPrintingLogger())
			 .appendNext((level, msg) -> {
				 if (level == Level.DEBUG)
				 System.out.println("Debug...");
			 });
		 logger.log(Level.INFO, "msg 1");
		 logger.log(Level.DEBUG, "msg 2");
		 
		 
		 Context1 context = new Context1();
		 for (int i = 0; i < 30; i++) context.alarm(); 
		 
		 
		 
		// a + b - (c + 10)
		 Expr expr = minus(
		 plus(var("a"), var("b")),
		 plus(var("c"), num(10)));
		 
		 // context
		 Map<String, Integer> context = new HashMap<>();
		 context.put("a", 10);
		 context.put("b", 20);
		 context.put("c", 13);
		 
		 // interpret
		 int result = expr.eval(context);
		 System.out.println(result); 
	}
}
