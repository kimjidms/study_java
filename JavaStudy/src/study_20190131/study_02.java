package study_20190131;

public class study_02 {
	static class Wrapper<T> {
		 private T item;
		 Wrapper(T item) { this.item = item; }
		 public T getItem() { return item; }
	}
	
	public static void main(String[] args) {
		 Wrapper<String> w1 = new Wrapper<>("abc");
		 Wrapper<Object> w2 = new Wrapper<>("abc");
		 print(w1); // OK
		 // print(w2); // 컴파일 에러
		 Wrapper<? extends CharSequence> w3 = new Wrapper<>("abc");
		 // = new Wrapper<String>("abc");
		 // w3.setItem("def"); // 컴파일에러. 알수 없는 타입변수: ? extends CharSequence
	}
	
	static void print(Wrapper<? extends CharSequence> wrapper) {
		 CharSequence str = wrapper.getItem();
		 System.out.println(str);
	}
}