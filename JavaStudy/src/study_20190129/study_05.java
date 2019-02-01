package study_20190129;

class study_05 {
    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
            System.out.println("i = " + i);
            
            for(int j = 0; j<10; j++) {
                System.out.println(i + " * " + j + " = " + (i * j));
                
                if (i % 3 == 0) {
                    break;
                }
            }
            
            System.out.println("\n");
        }
     } 
}