package 김은지_ch07;

import java.util.Objects;

public class ImmutableStringList implements StringList {
	
	private StringList list;
	
	public ImmutableStringList(StringList list) {
		Objects.requireNonNull(list, "list");
	    this.list = list;
	}

	@Override
	public void add(String value) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

	@Override
	public boolean isEmpty() {
		 return list.isEmpty();
	}

	@Override
	public int size() {
		 return list.size();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

	@Override
	public void add(int index, String value) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

	@Override
	public String get(int index) {
		return list.get(index);
	}

	@Override
	public void remove(int index) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

}
