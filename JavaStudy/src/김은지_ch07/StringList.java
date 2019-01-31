package 김은지_ch07;

public interface StringList{
	 void add(String value) throws Exception;
	 void add(int index, String value) throws Exception;
	 String get(int index) throws Exception;
	 void remove(int index) throws Exception;
	 
	 boolean isEmpty();
	 int size();
	 void clear(); 
	 
	 static StringList of(String... values) {
		 // values가 들어있는 StringList 반환
		 return null;
	 }
}