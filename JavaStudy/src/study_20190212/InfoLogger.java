package study_20190212;

public class InfoLogger implements Logger {
	 public void log(Level level, String msg) {
		 if (level == Level.INFO) System.out.println("INFO: " + msg);
	 }
}
