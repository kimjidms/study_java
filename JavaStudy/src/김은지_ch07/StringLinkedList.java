package 김은지_ch07;

public class StringLinkedList implements StringList {

	private Node head;
    private Node tail;
    private int size = 0;
    
    private class Node{
    	
        private String str;
        private Node next;
        
        public Node(String value) {
            this.str = value;
            this.next = null;
        }
    }
    
    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }
    
    
	@Override
	public void add(String value) {
		Node newNode = new Node(value);

		newNode.next = head;
		head = newNode;
        size++;
        
        if(head.next == null){
            tail = head;
        }
        
	}
	

	public void add(int index, String value) {
		try {
	
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
	
			Node temp1 = node(index-1);
		    Node temp2 = temp1.next;
		    
		    Node newNode = new Node(value);
		    
			temp1.next = newNode;
			newNode.next = temp2;
			
			size++;
			
		    if(newNode.next == null){
		        tail = newNode;
		    }
			
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
	}
	

	public String get(int index) {
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
		    
		    Node temp = head;
		    
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}

			if (temp.next != null)
				return temp.next.str;
			
			else
				return null;
		    
		} catch (IndexOutOfBoundsException e){
			System.out.println(e);
		}
		return null;
	}


	public void remove(int index) {  
		try {
			if(index < 0 || index > size()) throw new IndexOutOfBoundsException();
			
			Node headNode = this.head;
		       if(headNode == null) { 
		    	   System.out.println("No data");
		       }
		       
		       Node p = headNode;

		       for(int i = 0; i < index-1; i++){
		           p = p.next;
		       }
		       
		       p.next = p.next.next;
		       this.size--;
			
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
    	this.head = null;
	}
}


