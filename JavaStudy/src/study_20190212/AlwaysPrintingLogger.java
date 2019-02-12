package study_20190212;

public class AlwaysPrintingLogger implements Logger {
	 public void log(Level level, String msg) {
		 System.out.println("PRINT: " + msg);
	 }
}
