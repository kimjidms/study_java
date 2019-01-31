package 김은지_ch08;

import java.util.*;

public class calendar {
	 public static void main(String[] args) {
		 
		  //현재 날짜와 시간 정보를 가진 Calendar 객체를 생성한다. 
		  Calendar calendar = Calendar.getInstance();
		  
		  int year = calendar.get(Calendar.YEAR);
		  int month = calendar.get(Calendar.MONTH) + 1;
		  
		  System.out.println("\n           "+year + "년"+ month + "월\n");
		  System.out.println(" SUN MON THU WEN THR FRI SAT");
		  System.out.println(" ---------------------------");
		  
		  Calendar sDay = Calendar.getInstance();
		  Calendar eDay = Calendar.getInstance();
		  
		  sDay.set(year, month-1, 1);
		  eDay.set(year, month, 1);
		  eDay.add(Calendar.DATE, -1);
		  
		  int START_DAY_OF_WEEK = 0;
		  int END_DAY = 0;
		  
		  START_DAY_OF_WEEK = sDay.get(Calendar.DAY_OF_WEEK);
		  END_DAY = eDay.get(Calendar.DATE);
		  
		  for (int i = 1; i< START_DAY_OF_WEEK; i++) {
			   System.out.print("    ");
		  }
		  
		  for (int i =1, n = START_DAY_OF_WEEK; i<=END_DAY; i++, n++) {
			   System.out.print((i<10)?"   " + i :"  "+ i);
			   if(n%7 ==0) System.out.println();
		  }
	 }
}
