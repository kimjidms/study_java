package study_20190212;

public interface Logger {
	enum Level { INFO, DEBUG }
	void log(Level level, String msg);
	
	default Logger appendNext(Logger next) {
		 return ((level, msg) -> {
			 log(level, msg); next.log(level, msg);
		 });
	 }
}
