package 김은지_ch07;

public class exceptionMain {
	public static void main(String[] args) {
		try {
			 StringArrayList list = new StringArrayList(5);
			 ImmutableStringList ilist = new ImmutableStringList(list);
			 list.add("Hi, I'm Eunji");
		} catch (Exception e){
			 System.out.println(e);
		}
	}
}