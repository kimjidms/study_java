package 김은지_ch09;

public class exceptionMain {
    public static void main(String[] args) {
        try {
             StringArrayList list = new StringArrayList(5);
             ImmutableStringList iList = new ImmutableStringList(list);
             iList.add("Hi, I'm Eunji");
        } catch (Exception e){
             System.out.println(e);
        }
    }
}