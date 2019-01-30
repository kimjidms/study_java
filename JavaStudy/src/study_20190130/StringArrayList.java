package study_20190130;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class StringArrayList {
	
	 // 멤버 변수 선언
	 int idx;
	 String[] list;

	 // 생성자 생성
	 StringArrayList() { }
	 
	 // capacity만큰 배열 할당
	 StringArrayList(int capacity) {
		list = new String[capacity];
	 }
	 
	// 특정위치의 값을 반환. index =< size 가정
	String get(int index) {
		return list[index];
	 } 
	 
	 // 리스트가 비었는지 확인
	 boolean isEmpty() {
		 return list.length == 0;
	 } 
	 
	 // 리스트에 저장된 사이즈
	 int size() { 
		 return idx;
	 }
	 
	 // add()시 배열 공간이 부족하면 확보
	 void ensureCapacity() {
		 list = Arrays.copyOf(list, ++idx);
	 } 
	 
	// 특정위치 값을 삭제.
	 void remove(int index) { 
		 
		 for(int i = index; i<list.length-1; i++) {
			 list[index] = list[index+1];
		 }
		 
		 System.arraycopy(list, 0, list, 0, list.length-1);
	 }
	 
	// 리스트 마지막에 값 추가
	 void add(String string) { 
		String[] tmp = new String[list.length + 1];

		System.arraycopy(list, 0, tmp, 0, list.length);
		tmp[idx-1] = string;
		list = tmp;
	 } 
	 
	 // 특정위치에 값 추가.
	 void add(int index, String string) {
		if (list[index] != null) {
			
	         // 값 추가된 배열 신규 생성
	         ensureCapacity();
	         
	         for (int i = list.length - 1; i > index; i--) {
	            list[i] = list[i - 1];
	         }
	         list[index] = string;
	         
	      } else {
	    	  list[index] = string;
	      }
	 }
		 
	 // values 를 가지는 리스트 생성후 리턴
	 void of(String... values) {
		 String[] value = values;
		 String[] tmp = new String[list.length + value.length - 1];
		 
		 System.arraycopy(list, 0, tmp, 0, list.length);
		 System.arraycopy(value, 0, tmp, list.length+1, value.length);
		 
		 list = tmp;
	 } 
	 
	 
	 public static void main(String[] args) throws Exception {

			StringArrayList list = new StringArrayList();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			String str;
			int index;
			
			while (true) {
				System.out.println("=================================================================================");
				System.out.println("명령어 : 1.add() 2.add(idx) 3.get(idx) 4.remove(idx) 5.size()  6.show()  7.exit()");
				System.out.print("입력 : ");
				int command = Integer.parseInt(br.readLine());
				System.out.println("=================================================================================");
				
				switch (command) {
				case 1:
					System.out.print("리스트에 추가할 데이터를 입력하세요 : ");
					str = br.readLine();
					list.add(str);
					break;
				case 2:
					System.out.print("리스트에 추가할 데이터를 입력하세요 : ");
					str = br.readLine();
					System.out.print("데이터를 추가할 인덱스를 입력하세요 : ");
					index = Integer.parseInt(br.readLine());
					list.add(index, str);
					break;
				case 3:
					System.out.print("데이터를 확인할 인덱스를 입력하세요 : ");
					index = Integer.parseInt(br.readLine());
					System.out.println("[확인 데이터] : " + list.get(index));
					break;
				case 4:
					System.out.print("데이터를 삭제할 인덱스를 입력하세요 : ");
					index = Integer.parseInt(br.readLine());
					System.out.println("[삭제 데이터] : " + list.get(index));
					list.remove(index);
					break;
				case 5:
					System.out.println("[리스트의 크기] : " + list.size());
					break;
				case 6:
					for (int i = 0; i <= list.size(); i++) {
						System.out.print(list.strArr[i] +" ");
					}
					break;
				case 7:
					System.out.println("[종료합니다.]");
					return;
				default:
					System.out.println("명령어를 잘못 입력하였습니다. (1~6)");
					break;
				}
				
				System.out.println();
			}
			   
		}
}