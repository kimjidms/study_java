package 김은지_ch12;

public class test_02 {
    public static void main(String[] args) {

        String[] arr =  {"B", "A", "R", "V", "K", "S", "O", "Q"};
        ArrayIterable<String> iterable = new ArrayIterable<>(arr);

        iterable.iterator();
    }
}
