package 김은지_ch07;

import java.util.Arrays;

class StringArrayList implements StringList{

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
	@Override
	public void add(String string) {
		if (isEmpty()) {
			ensureCapacity();
			list[0] = string;
		} else {
			ensureCapacity();
			list[size()-1] = string;
		}
	}

	// 특정위치에 값 추가.
	@Override
	public void add(int index, String string) {
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
			
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
	
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}		
	}

	// 특정위치의 값을 반환. index =< size 가정
	@Override
	public String get(int index) {
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
			return list[index];

		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		
		return null;	
	}

	// 특정위치 값을 삭제.
	@Override
	public void remove(int index) {
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
			String[] tmp = new String[list.length-1];

			System.arraycopy(list, 0, tmp, 0, index);
			System.arraycopy(list, index + 1, tmp, index, tmp.length-index);

			list = tmp;
			idx = list.length;
			
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
	}

	// 리스트가 비었는지 확인
	@Override
	public boolean isEmpty() {
		return list.length == 0;
	}

	// 리스트에 저장된 사이즈
	@Override
	public int size() {
		return idx;
	}

	// add()시 배열 공간이 부족하면 확보
	public void ensureCapacity() {
		list = Arrays.copyOf(list, ++idx);
	}
	
	@Override
	public void clear() {
		String[] tmp = new String[0];
		System.arraycopy(list, 0, tmp, 0, 0);
		list = tmp;
	}

	// values 를 가지는 리스트 생성후 리턴
	public void of(String... values) {
		String[] value = values;
		String[] tmp = new String[list.length + value.length];

		System.arraycopy(list, 0, tmp, 0, list.length);
		System.arraycopy(value, 0, tmp, size()+2, value.length);

		list = tmp;
	}
}