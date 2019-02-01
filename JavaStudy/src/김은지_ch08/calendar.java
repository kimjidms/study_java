package 김은지_ch08;

import java.util.*;

public class calendar {
	 public static void main(String[] args) {
		 
		  //현재 날짜와 시간 정보를 가진 Calendar 객체를 생성한다. 
		  Calendar calendar = Calendar.getInstance();
		  
		  int year = calendar.get(Calendar.YEAR);
		  int month = calendar.get(Calendar.MONTH) + 1;
		  int month_start_day = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		  
		  calendar.set(Calendar.DAY_OF_MONTH, 1);
		  int end_day_of_week = calendar.get(Calendar.DAY_OF_WEEK);
		  int end_day = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		  System.out.println("\n                              "+year + "년"+ month + "월\n");
		  System.out.println(" \tSUN\t MON\t THU\t WEN\t THR\t FRI\t SAT\t");
		  System.out.println(" -----------------------------------------------------------------");
		  
		 
		  for(int i = 1; i < end_day; ){
			   if(i < end_day_of_week){
				    System.out.print("\t ");
				    i++;
			   }
			   else if(i >= end_day_of_week){
				   
				    while(true){
					     System.out.print("\t" + month_start_day);
					     
					     if(i % 7 == 0) { 
					    	 System.out.println();
					     }
					     
					     if(month_start_day == end_day) {
					    	 break;
					     }
			
					     month_start_day++;
					     i++;
				    }
			   }
		  }
		  System.out.println();
	 }
}
