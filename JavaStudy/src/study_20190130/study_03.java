package study_20190130;

class study_03 {
     public static void main(String[] args) {
         int i = 0;
         String str = "Hello";
         
         study_02 v = new study_02();
         study_02 v2 = method(i, str, v);

    }
     
     static study_02 method(int p1, String p2, study_02 p3) {

         p1 += 100; 
         p2 += ", World";
         p3.b = 42;

         p3 = new study_02();

         return p3;
    }
}