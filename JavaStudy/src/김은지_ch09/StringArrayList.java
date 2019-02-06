package 김은지_ch09;

import java.util.Arrays;

public class StringArrayList<T> implements List<T> {

	// 멤버 변수 선언
	private T[] list = (T[]) new String[0];

	public StringArrayList() { }

	public StringArrayList(int capacity) {
		this.list = (T[]) new String[capacity];
	}

	// 리스트 마지막에 값 추가
	@Override
	public void add(T value) {
		ensureCapacity();
		list[size()-1] = value;
	}

	// 특정위치에 값 추가.
	@Override
	public void add(int index, T value) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

		if (isEmpty()) {
			ensureCapacity();
			list[index] = value;
		} else {
			ensureCapacity();
			for (int i = index; i < size()-1; i++) {
				list[i+1] = list[i];
			}
			list[index] = value;
		}
	}

	// 특정위치의 값을 반환. index =< size 가정
	@Override
	public T get(int index) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		return list[index];
	}

	// 특정위치 값을 삭제.
	@Override
	public void remove(int index) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		String[] tmp = new String[list.length-1];

		System.arraycopy(list, 0, tmp, 0, index);
		System.arraycopy(list, index + 1, tmp, index, tmp.length-index);

		list = (T[]) tmp;
	}

	// 리스트가 비었는지 확인
	@Override
	public boolean isEmpty() {
		return list.length == 0;
	}

	// 리스트에 저장된 사이즈
	@Override
	public int size() {
		if (list == null) {
			return 0;
		} else {
			return list.length;
		}
	}

	// add()시 배열 공간이 부족하면 확보
	public void ensureCapacity() {
		int idx = list.length;
		list = Arrays.copyOf(list, ++idx);
	}

	@Override
	public void clear() {
		list = null;
	}


	public T[] of(String... values){
		String[] value = values;
		String[] tmp = new String[list.length + value.length];

		System.arraycopy(list, 0, tmp, 0, list.length);
		System.arraycopy(value, 0, tmp, size()+2, value.length);

		list = (T[]) tmp;
		return this.list;
	}
}