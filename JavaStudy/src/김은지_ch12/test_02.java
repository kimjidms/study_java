package 김은지_ch12;

public class test_02 {
    public static void main(String[] args) {

        String[] arr =  {"B", "A", "R", "V"};
        ArrayIterable<String> iterable = new ArrayIterable<>(arr);

        for (String i : iterable) {
            System.out.println(i);
        }
    }
}
