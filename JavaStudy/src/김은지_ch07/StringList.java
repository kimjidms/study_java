package 김은지_ch07;

public interface StringList{

	 void add(String value);
	 void add(int index, String value);
	 String get(int index);
	 void remove(int index);
	 
	 boolean isEmpty();
	 int size();
	 void clear(); 
	 
	 static StringList of(String... values) { return null; }
	
}