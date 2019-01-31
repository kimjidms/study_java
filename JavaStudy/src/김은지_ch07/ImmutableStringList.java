package 김은지_ch07;

public class ImmutableStringList implements StringList {
	public ImmutableStringList(StringList list) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

	@Override
	public void add(String value) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		return 0;
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
		return null;
	}

	@Override
	public void remove(int index) {
		throw new UnsupportedOperationException("UnsupportedOperationException");
	}

}
