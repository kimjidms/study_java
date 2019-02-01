package study_20190131;

import java.io.UnsupportedEncodingException; 

public class study_01 {
    public static void main(String[] args)
     throws UnsupportedEncodingException {
        
         String str = "한글";
         
         // 리눅스 
         printByteArrays(str.getBytes("UTF-8"));
         // 윈도우
         printByteArrays(str.getBytes("CP949"));
     }
    
     private static void printByteArrays(byte[] arr) {
         StringBuilder builder = new StringBuilder();
         
         for (byte b : arr) {
             builder.append(String.format("%02X", b));
         }
         
         System.out.println(builder.toString());
     } 
}