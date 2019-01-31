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
		
		if(size == 0) {
			newNode.next = head;
			head = newNode;
			size++;
			    
			if(head.next == null){
				tail = head;
			}
			
		} else {
	        tail.next = newNode;
	        tail = newNode;
	        size++;
		 }
	}

	@Override
	public void add(int index, String value) {
	    Node temp1 = node(index-1);
	    Node temp2 = temp1.next;
	    
	    Node newNode = new Node(value);
	    
		temp1.next = newNode;
		newNode.next = temp2;
		
		size++;
		
	    if(newNode.next == null){
	        tail = newNode;
	    }
	}
	

	@Override
	public String get(int index) {
		
	    Node temp = head;
	    
	    for (int i = 0; i<index; i++) {
	    	temp = temp.next;
	    }
	    
	    if (temp.next != null) {
	    	return temp.next.str;
	    } else {
	    	return null;
	    }
	}

	@Override
	public void remove(int index) {   
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


