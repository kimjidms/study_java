package study_20190212;

public class Context {
	 private AlarmState state;

	 public Context() { this.state = new WeekdayAlarm(); }
	 public void setState(AlarmState state) { this.state = state; }
	 public void alarm() { state.alarm(this); }
}
