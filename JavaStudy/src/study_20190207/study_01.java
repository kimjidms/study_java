package study_20190207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;



public class study_01 {
    public static void main(String[] args) {
    	
    	/*
    	 * 1
    	 */
    	List<String> list = Arrays.asList("1234", "5678");
    	Stream<Integer> intStream = list.stream()
    	 .flatMap(s -> Arrays.asList(Integer.valueOf(s)).stream());
    	intStream.forEach(System.out::println);
    	System.out.println();
    	
    	/*
    	 * 2
    	 */
    	list.stream()
    	 .map(Integer::valueOf)
    	 .forEach(System.out::print);
    	System.out.println();
    	
    	/*
    	 * 3
    	 */
    	Stream<Integer> s1 = Stream.generate(() -> 1).limit(2);
    	Stream<Integer> s2 = Stream.generate(() -> 2).limit(3);
    	Stream<Integer> s3 = Stream.concat(s1, s2);
    	s3.forEach(System.out::print);
    	System.out.println();System.out.println();
    	
    	/*
    	 * 4
    	 */
    	Stream.of(0, 1, 2, 3, 2, 1, 0)
    	 .peek(i -> System.out.println("peek1: " + i))
    	 .sorted() // 정렬 되기 전 위 peek 먼저 수행
    	 .peek(i -> System.out.println("peek2: " + i))
    	 .forEach(i -> System.out.println("forEach: " + i));
       	System.out.println();System.out.println();
       	
       	
       	/*
    	 * 5
    	 */
    	Stream.of("abc", "def")
    	 .reduce(String::concat)
    	 .ifPresent(System.out::println); 
    	
    	
    	String str = Stream.of("abc", "def")
    			 .reduce(new StringBuilder(), StringBuilder::append, (a,b) -> null)
    			 .toString();
    	
    	int count = Stream.of("a", "bc", "def", "ghij").parallel()
    			 .reduce(0, (c, s) -> c + s.length(), Integer::sum);
       	System.out.println();System.out.println();
    	
       	
       	/*
    	 * 6
    	 */
    	List<String> list1 = Stream.of("a", "bc")
    			 .collect(toList()); // Collectors.toList()
    	System.out.println(list1);
    	Set<String> set = Stream.of("a", "b", "c", "a")
    			 .collect(toSet()); // Collectors.toSet()
    	System.out.println(set);
    	ArrayList<String> list2 = Stream.of("a", "b", "c")
    			 .collect(toCollection(ArrayList::new));
    	System.out.println(list2);
    	Map<Integer, String> map = Stream.of("abc", "ab")
    			 .collect(toMap(String::length, s -> s));
    	System.out.println(map);
       	System.out.println();System.out.println();
       	
       	
       	/*
    	 * 7
    	 */
       	String s11 = Stream.of("a","b","c").collect(joining());
       	System.out.println(s11);
       	
       	String s22 =  Stream.of("a", "b", "c")
       		 .collect(joining(", "));
       	System.out.println(s22);
       	
       	String s33 = Stream.of("a", "b", "c")
       		 .collect(joining(", ", "<", ">"));
       	System.out.println(s33);
        System.out.println();System.out.println();
        
        
        /*
    	 * 8
    	 */ 
       int sum1 = Stream.of("abc","xy")
    		   .collect(reducing(0, String::length, Integer::sum));
       System.out.println(sum1);
       int sum2 = Stream.of("abc","xy").map(String::length)
    		   .reduce(0, Integer::sum);
       System.out.println(sum2);
       System.out.println();System.out.println();
       
       /*
   	    * 9
   	    */
       double average = Stream.of("abc", "de")
    		   .collect(averagingInt(String::length));
       System.out.println(average);
       Optional<String> min = Stream.of("abc", "def")
    		   .collect(minBy(Comparator.reverseOrder()));
       System.out.println(min);
       System.out.println();System.out.println();
       
       
       /*
   	    * 10
   	    */
       Map<Boolean, List<String>> map1 = Stream.of("abc", "abc", "def")
    		   .collect(partitioningBy(s -> s.startsWith("a")));
	   System.out.println(map1);
	   Map<Boolean, Long> map2 = Stream.of("abc", "abc", "def")
    		   .collect(partitioningBy(s -> s.startsWith("a"), counting()));
       System.out.println(map2);
       System.out.println();System.out.println();
       
       
       /*
   	    * 11
   	    */
       Map<Character, List<String>> map11 = Stream.of("abc","ab","def")
    		   .collect(groupingBy(s -> s.charAt(0)));
       System.out.println(map11);
       
       Map<Integer, Map<Character, List<String>>> map22 = Stream
    		   .of("abc", "ab", "def")
    		   .collect(groupingBy(String::length, groupingBy(s -> s.charAt(0))));
	   System.out.println(map22);
    		  
       Map<Integer, List<String>> map33 = Stream.of("abc", "ab", "def")
    		   .collect(groupingBy(String::length, TreeMap::new, toList()));
       System.out.println(map33);
       System.out.println();System.out.println();
       
       
       /*
   	    * 12
   	    */
       
    }
}