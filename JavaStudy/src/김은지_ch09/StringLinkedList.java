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
	public void add(String value) {
		 if(tail == null) {
	        	head = tail = new Node(value);
	        } else {
	        	Node lastNode = new Node((String) value);
	        	tail.next = lastNode;
	        }
	        size++;
	}

	@Override
	public void add(int index, String value) {
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
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
			
			Node headNode = head;
		       if(headNode == null) { 
		    	   System.out.println("No data");
		       }
		       
		       Node p = headNode;

		       for(int i = 0; i < index-1; i++){
		           p = p.next;
		       }
		       
		       p.next = p.next.next;
		       size--;
			
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

