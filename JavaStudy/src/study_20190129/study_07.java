package study_20190129;

import java.util.Arrays;
import java.util.List;

class study_07 {
    public static void main(String[] args) {
        
        int[] a = { 3, 1, 2 };
        
        int[] b = Arrays.copyOf(a, 5);
        
        Arrays.fill(b, 3, 5, 100);
        Arrays.fill(b, 10);
        Arrays.sort(a);
        
        String str = Arrays.toString(a);
        boolean isSame = Arrays.equals(a, b);
        List<String> list = Arrays.asList("abc", "def");
        
        System.out.println(str);
        System.out.println(isSame);
        System.out.println(list);
     } 
}