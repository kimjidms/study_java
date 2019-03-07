package study_20190212;


public class WeekdayAlarm implements AlarmState {
	 private int count = 0;
	 
	 public void alarm(Context1 context) {
		 System.out.println("WAKE UP!");
		 if (++count >= 5) context.setState(new WeekendAlarm());
	 }
}


