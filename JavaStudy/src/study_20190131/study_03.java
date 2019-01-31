package study_20190131;

public class study_03 {
	static <T> T[] toArray(T... args) {
		return args;
	}
	
	static <T> T[] makeArray(T t) {
		return toArray(t); // toArray(new Object[] { t });
	}
	
	public static void main(String[] args) {
		 String[] arr1 = toArray("Hello");
		 // String[] arr2 = makeArray("World"); // ClassCastException 
		 Object[] arr3 = makeArray("!");
		 arr3[0] = 1;
	}
}