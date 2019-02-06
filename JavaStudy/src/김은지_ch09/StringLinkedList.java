package 김은지_ch09;

public class StringLinkedList<T>  implements List<T> {

	private Node head;
	private Node tail;
	private int size = 0;

	private class Node{

		private T str;
		private Node next;

		public Node(T value) {
			this.str = value;
			this.next = null;
		}
	}


	@Override
	public void add(T value) {
		if(tail == null) {
			head = tail = new Node(value);
		} else {
			Node lastNode = new Node(value);
			tail.next = lastNode;
			tail = lastNode;
		}
		size++;
	}

	@Override
	public void add(int index, T value) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

		Node temp = new Node(value);

		if(index == 0) {
			temp.next = head;
			head = temp;
			size++;
		} else if (index > 0 && index < size-1) {

			Node after = find(index).next;
			find(index).next = temp;
			temp.next = after;
			size++;

		} else {
			add(value);
		}
	}


	@Override
	public T get(int index) {
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		return find(index).str;
	}

	@Override
	public void remove(int index) {
		size--;
		if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

		if(index == 0) {
			if (size > 1) {
				head = head.next;
			} else {
				clear();
			}
		} else if(index < size -1) {
			Node after = find(index).next.next;
			find(index).next = after;
		} else {
			tail = find(index).next;
		}

	}

	private Node find(int index) {
		Node before = head;

		for(int i=0; i<index; i++) {
			before = before.next;
		}

		return before;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}
}

