package 김은지_ch07;

public class ImmutableStringList implements StringList {
	public ImmutableStringList(StringList list) {
		
		
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
	}

}
