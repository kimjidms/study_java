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
		 
		 
		 Context context = new Context();
		 for (int i = 0; i < 30; i++) context.alarm(); 
	}
}
