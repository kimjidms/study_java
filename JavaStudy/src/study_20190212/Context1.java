package study_20190212;

public class Context1 {
	 private AlarmState state;

	 public Context1() { this.state = new WeekdayAlarm(); }
	 public void setState(AlarmState state) { this.state = state; }
	 public void alarm() { state.alarm(this); }
}
