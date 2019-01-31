package 김은지_ch07;


public class Main {
	public static void main(String[] args) {
        System.out.println(" ---------------- StringArrayListTest  ----------------");
	        
	        StringArrayList list = new StringArrayList(0);
	
			list.add("a"); // [a]
			print("add(a)", list);
	
			StringArrayList another = new StringArrayList();
			print("another", another);
	
			list.add(0, "b"); // [b, a]
			print("add(0, b)", list);
	
			list.add(1, "c"); // [b, c, a];
			print("add(1, c)", list);
	
			for (int i = 0; i < 100; i++) {
				list.add(i + "");
			}
			print("add numbers", list);
	
			list.remove(0); // [c, a, 0, ... ]
			print("remove(0)", list);
	
			list.remove(list.size() - 1);
			print("remove last", list);
	
			list.remove(1); // [c, 0, ... ]
			print("remove(1)", list);
			
			
		System.out.println("---------------- StringArrayListTest  ----------------");
		System.out.println();
			
			
        System.out.println("--------------- StringLinkedListTest  ---------------");
        
	        StringLinkedList stringLinkedList = new StringLinkedList();
	        
//	        String[] array =  {"1","a","2","b","3","c"};
//	        
//	        for(int i = 0; i < array.length; i++){
//	        	stringLinkedList.add(array[i]);
//	        }
//	       
//	        stringLinkedList.add(0, "5");
//	        stringLinkedList.add(3, "6");
//	        stringLinkedList.get(3);
//	        stringLinkedList.remove(2);
//
//	        stringLinkedList.clear();
	        
	        stringLinkedList.add("a"); // [a]
			printList("add(a)", stringLinkedList);
	
			StringLinkedList anotherList = new StringLinkedList();
			printList("another", anotherList);
	
			stringLinkedList.add(0, "b"); // [b, a]
			printList("add(0, b)", stringLinkedList);
	
			stringLinkedList.add(1, "c"); // [b, c, a];
			printList("add(1, c)", stringLinkedList);
	
			for (int i = 0; i < 100; i++) {
				stringLinkedList.add(i + "");
			}
			printList("add numbers", stringLinkedList);
	
			stringLinkedList.remove(0); // [c, a, 0, ... ]
			printList("remove(0)", stringLinkedList);
	
			stringLinkedList.remove(list.size() - 1);
			printList("remove last", stringLinkedList);
	
			stringLinkedList.remove(1); // [c, 0, ... ]
			printList("remove(1)", stringLinkedList);
			
        System.out.println("--------------- StringLinkedListTest  ---------------");
	}
	
	private static void print(String name, StringArrayList list) {
		System.out.println(name);
		System.out.print("size = " + list.size() + ", [");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println("]");
		System.out.println("-----------------");
	}
	
	private static void printList(String name, StringLinkedList list) {
		System.out.println(name);
		System.out.print("size = " + list.size() + ", [");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + ", ");
		}
		System.out.println("]");
		System.out.println("-----------------");
	}
}
