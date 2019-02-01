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

	// capacity 만큼 배열 할당
	StringArrayList(int capacity) {
		list = new String[capacity];
	}

	// 리스트 마지막에 값 추가
	void add(String string) {
		if (isEmpty()) {
			ensureCapacity();
			list[0] = string;
		} else {
			ensureCapacity();
			list[size()-1] = string;
		}
	}

	// 특정위치에 값 추가.
	void add(int index, String string) {
		if (isEmpty()) {
			ensureCapacity();
			list[index] = string;
		} else {
			ensureCapacity();

			for (int i = index; i < size()-1; i++) {
				list[i+1] = list[i];
			}
			list[index] = string;
		}
	}

	// 특정위치의 값을 반환. index =< size 가정
	String get(int index) {
		return list[index];
	}

	// 특정위치 값을 삭제.
	void remove(int index) {
		String[] tmp = new String[list.length-1];

		System.arraycopy(list, 0, tmp, 0, index);
		System.arraycopy(list, index + 1, tmp, index, tmp.length-index);

		list = tmp;
		idx = list.length;
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


	// values 를 가지는 리스트 생성후 리턴
	void of(String... values) {
		String[] value = values;
		String[] tmp = new String[list.length + value.length];

		System.arraycopy(list, 0, tmp, 0, list.length);
		System.arraycopy(value, 0, tmp, size()+2, value.length);

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
					for (int i = 0; i < list.size(); i++) {
						System.out.print(list.get(i) + ", ");
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