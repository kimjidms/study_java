package 김은지_ch13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    	
    	for (int i = 0; i < 500; i++) {
    		System.out.println("students ==> " + students.get(i).name + ", " + students.get(i).age + 
    				", " + students.get(i).grade + ", " + students.get(i).genders);
    	}
    	System.out.println("\n=============================================================\n");
    
    	
    	// 1. 학년별 인원수출력 (학년순)
    	Map<Integer, Integer> map = new HashMap<>();

    	IntStream.range(0, students.size())
    		.forEach(i -> {
    			int key = students.get(i).grade;
    			int count = Optional.ofNullable(map.get(key)).orElse(0);
    			map.put(key, count+1);
    		});
    	System.out.println("1. Grade Count ==> " + map);
    	
  
    	// 2. 남녀별 인원수 출력
    	Map<String, Integer> map2 = new HashMap<>();
    	
    	IntStream.range(0, students.size())
			.forEach(i -> {
				String key = students.get(i).genders;
				int count = Optional.ofNullable(map2.get(key)).orElse(0);
				map2.put(key, count+1);
		});
    	System.out.println("2. Gender Count ==> " + map2);
    	
    	
		// 3. 학년별 남녀별 인원수 출력 (학년순)
    	System.out.println("3. Grade/Gender Count ==> ");

    	
  
		// 4. 전체학생 나이 평균
    	List<Integer> ageList = new ArrayList<>();
    	
    	IntStream.range(0, students.size())
    	.forEach(i -> {
    		ageList.add(students.get(i).age);
    	});
    	
    	double average = ageList.stream().mapToInt(i ->i).average().orElse(0);
    	System.out.println("4. All Students Age Avg ==> " + average);
    
	  
    	
		// 5. 학년별 나이 평균 출력 (학년순)
    	students.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	System.out.println("5. Grade/Age Avg ==> ");

    	
    	
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
    	System.out.println("7. Age/Grade Same Name ==> ");
    	
    }
}