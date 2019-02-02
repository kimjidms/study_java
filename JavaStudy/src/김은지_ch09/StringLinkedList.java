package 김은지_ch09;

public class StringLinkedList implements StringList {

	private Node head;
	private Node tail;
	private int size = 0;

	private class Node{

		private String str;
		private Node next;

		public Node(Object value) {
			this.str = (String) value;
		}
	}


	@Override
	public void add(Object value) {
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
	public void add(int index, Object value) {
		try {

			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

			Node temp = new Node((String) value);

			if(index == 0) {
				temp.next = head;
				head = temp;
				size++;
			} else if (index > 0 && index < size-1) {
				Node before = head;

				for(int i=0; i<index; i++) {
					before = before.next;
				}

				Node after = before.next;
				before.next = temp;
				temp.next = after;
				size++;

			} else {
				add(value);
			}
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
	}

	@Override
	public String get(int index) {
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

			Node node = head;

			if(index > 0) {
				for(int i=0; i<index; i++) {
					node = node.next;
				}
			}
			return node.str;

		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void remove(int index) {
		try {
			size--;
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();

			if(index == 0) {
				if (size > 1) {
					head = head.next;
				} else {
					clear();
				}
			} else if(index > 0 && index < size -1) {
				Node befor = head;

				for (int i = 0; i < index -1; i++) {
					befor = befor.next;
				}

				Node after = befor.next.next;
				befor.next = after;
			} else {
				Node node = head;

				for (int i = 0; i < index; i++) {
					node = node.next;
				}
				tail = node;
			}
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
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
	}
}

