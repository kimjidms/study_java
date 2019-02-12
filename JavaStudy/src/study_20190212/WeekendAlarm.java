package study_20190212;

public class WeekendAlarm implements AlarmState {
	 private int count = 0;
	 public void alarm(Context context) {
		 if (++count >= 2) context.setState(new WeekdayAlarm());
	 }
}
	