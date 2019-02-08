package 김은지_ch13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
	
    	List<Student> students = new ArrayList<>(500);
    	
    	for (int i = 0; i < 500; i++) {
		     int age = ThreadLocalRandom.current().nextInt(18, 31);
	    	 int grade = ThreadLocalRandom.current().nextInt(1,5);
	
	    	 Gender gender = new Gender();
	    	 String genders = gender.getGender();
	    	 
	    	 String name = NameGenerator.generate();
	    	 
	    	 Student student = new Student(age, grade, genders, name);
	    	 students.add(student);
    	}
    	
    	
    	// 1. 학년별 인원수출력 (학년순) 
    	Map<Integer, Integer> map = new HashMap<>();

    	IntStream.range(0, students.size())
    		.forEach(i -> {
    			int key = students.get(i).grade;
    			int count = Optional.ofNullable(map.get(key)).orElse(0);
    			map.put(key, count+1);
    		});
    
    	 List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
         Collections.sort(list, Comparator.comparing(Map.Entry::getKey));
         System.out.println("1. Grade Count ==> " + list);
         
  
         
    	// 2. 남녀별 인원수 출력
    	Map<String, Integer> map2 = new HashMap<>();
    	
    	IntStream.range(0, students.size())
			.forEach(i -> {
				String key = students.get(i).genders;
				int count = Optional.ofNullable(map2.get(key)).orElse(0);
				map2.put(key, count+1);
		});
    	
   	   List<Map.Entry<String, Integer>> list2 = new ArrayList<>(map2.entrySet());
       Collections.sort(list2, Comparator.comparing(Map.Entry::getKey));
       System.out.println("2. Gender Count ==> " + list2);
	    	
       
    	
		// 3. 학년별 남녀별 인원수 출력 
    	Map<Integer, Map<String, Long>> gradeGenderCount = new HashMap<>();
    	
    	IntStream.range(0, students.size())
		.forEach(i -> {
			int key = students.get(i).grade;
			
			Map<String, Long> value = new HashMap<>();
			IntStream.range(0, students.size())
			.forEach(j -> {
				String keys = students.get(j).genders;
				long values = students.stream().filter(x -> x.getGrade() == key && x.getGender() == keys).count();
				value.put(keys, values);
			});
			
			gradeGenderCount.put(key, value);
		});
    	System.out.println("3. Grade/Gender Count ==> " + gradeGenderCount);
    	
    	
    	
		// 4. 전체학생 나이 평균
    	List<Integer> ageList = new ArrayList<>();
    	
    	IntStream.range(0, students.size())
    	.forEach(i -> {
    		ageList.add(students.get(i).age);
    	});
    	
    	double average = ageList.stream().mapToInt(i ->i).average().orElse(0);
    	System.out.println("4. All Students Age Avg ==> " + average);
    
	  
    	
		// 5. 학년별 나이 평균 출력 (학년순)
    	Map<Integer, Double> gradeAgeAvg = new HashMap<>();
    	
    	IntStream.range(0, students.size())
    	.forEach(i -> {
    		int key = students.get(i).grade;
    		Double value = students.stream().filter(x -> x.getGrade() == key).mapToInt(x->x.getAge()).average().getAsDouble();
    		gradeAgeAvg.put(key, value);
    	});
    	
    	List<Map.Entry<Integer, Double>> list3 = new ArrayList<>(gradeAgeAvg.entrySet());
        Collections.sort(list3, Comparator.comparing(Map.Entry::getKey));
    	System.out.println("5. Grade/Age Avg ==> " + list3);
    	
    	
    	
		// 6. 이름이 외자인 학생 리스트 출력
    	List<String> nameList = new ArrayList<>();
    	
    	IntStream.range(0, students.size())
    	.forEach(i -> {
    		nameList.add(students.get(i).name);
    	});
    	
    	Stream<String> nameStream = nameList.stream().filter(s -> s.length() < 3);
    	System.out.print("6. Name Length < 3 ==> ");
    	nameStream.forEach(str -> System.out.print(str + ", "));
    	System.out.println();
    	
    	
    	
		// 7. 동명이인이 가장 많은 학생 리스트 출력 (나이순, 학년순)
    	Map<String, Integer> nameCount = new HashMap<>();
    			
    	IntStream.range(0, students.size())
			.forEach(i -> {
				String key = students.get(i).name;
				int count = Optional.ofNullable(nameCount.get(key)).orElse(0);
				nameCount.put(key, count+1);
		});
    	
    	nameCount.entrySet().stream()
	    	.sorted(Entry.comparingByValue())
	    	.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	    	
    	String name = Collections.max(nameCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    	List<Student> sameStudenList = new ArrayList<>();
    	
    	for (int i = 0; i <= nameCount.size(); i++) {
			  if (students.get(i).name.equals(name)) {
				  sameStudenList.add(students.get(i));
			  }
    	}
    	
    	sameStudenList.stream()
    		.sorted(Comparator.comparing(Student::getGrade))
    		.sorted(Comparator.comparing(Student::getAge));
    	
    	System.out.print("7. Age Same Name ==> {");
    	for(int i = 0; i< sameStudenList.size(); i++) {
    		System.out.print(sameStudenList.get(i).name + " , age = "+ sameStudenList.get(i).age + " , grade = "+ sameStudenList.get(i).grade + " / ");
    	}
    	System.out.print(" }");
   
    }
}