package 김은지_ch07;

public interface StringList{

	 void add(String value);
	 static void add(int index, String value) { }; 
	 static String get(int index) { return null; };
	 static void remove(int index) { };
	 
	 boolean isEmpty();
	 int size();
	 void clear(); 
	 
	 static StringList of(String... values) { return null; }
	 
	 static StringList immutableList(StringList list) {
		 return new ImmutableStringList(list);
	 }
}