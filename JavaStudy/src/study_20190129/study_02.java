package study_20190129;

class study_02 {
     public static void main(String[] args) {
         
         int a = 100;
         int b = 200;
         System.out.println("a=" + a + ", b=" + b);
         
         a = b;
         b = a;
        
         System.out.println("a=" + a + ", b=" + b);
         
         
         a = 100;
         b = 200;
         int temp = 0;
         
         // swap
         temp = a;
         a = b;
         b = temp;
         System.out.println("swap : a=" + a + ", b=" + b);  
     }
}