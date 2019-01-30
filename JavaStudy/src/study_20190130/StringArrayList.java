package study_20190130;

import java.util.Arrays;

class StringArrayList {
	
	 // 멤버 변수 선언
	 static String[] list = new String[] {"x", "y", "z"};

	 // 생성자 생성
	 StringArrayList() { }
	 
	 // capacity만큰 배열 할당
	 StringArrayList(int capacity) {
		list = new String[capacity];
	 }
	 
	// 리스트 마지막에 값 추가
	 static void add(String string) { 
		String[] tmp = new String[list.length + 1];
		for (int i = 0; i < list.length; i++) tmp[i] = list[i];
		tmp[tmp.length-1] = string;
		list = tmp;
	 } 
	 
	 // 특정위치에 값 추가. index < size
	 static void add(int index, String string) { 
		list[index] = string;
	 }
	 
	// 특정위치의 값을 반환. index =< size 가정
	 static String get(int index) {
		return list[index].toString();
	 } 
	 
	 // 특정위치 값을 삭제. index =< size 가정
	 static void remove(int index) { 
		 list[index] = null;
	 }
	 
	 // 리스트가 비었는지 확인
	 static boolean isEmpty() {
		 if(list.length == 0) {
			 return true;
		 } else {
			 return false;
		 }
	 } 
	 
	 // 리스트에 저장된 사이즈
	 static int size() { 
		 return list.length;
	 }
	 
	 // add()시 배열 공간이 부족하면 확보
	 static void ensureCapacity() { 
		 String[] tmp = new String[list.length + 1]; 
		 for (int i = 0; i < list.length; i++) tmp[i] = list[i];
		 list = tmp;
	 } 
	 
	 // values 를 가지는 리스트 생성후 리턴
	 static void of(String... values) {
		 String[] value = values;
		 String[] tmp = new String[list.length + value.length - 1]; 
		 
		 for (int i = 0; i < list.length-1; i++) {
			 tmp[i] = list[i];
		 } 
		
		 for (int i = 0; i < value.length; i++) {
			 tmp[list.length-1 + i] = value[i];
		 }
		 
		 list = tmp;
	 } 
	 
	 public static void main(String[] args) {
		 
		 for (String item : list) {
			  System.out.println(item.toString());
		 }
		 
		 add("Hi");
		 add(1, "Hello");
		 System.out.println("isEmpty : " + isEmpty());
		 System.out.println("size : " + size());
		 System.out.println("get : " + get(3));
		 ensureCapacity();
		 of("no1","no2","no3");
		 
		 for (String item : list) {
			 System.out.println(item.toString());
		 }
	 }
}