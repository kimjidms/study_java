package 김은지_ch13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
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
    	System.out.println("5. Grade/Age Avg ==> " + gradeAgeAvg);
    	
    	
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
    	Map<String, Integer> sameNameAndAge = new HashMap<>();
    	Map<String, Integer> sameNameAndGrade = new HashMap<>();
    			
    	IntStream.range(0, students.size())
			.forEach(i -> {
				String key = students.get(i).name;
				int count = students.stream().filter(x -> x.getName() == key).mapToInt(x->x.getAge()).sum();
				sameNameAndAge.put(key, count);
		});

    	IntStream.range(0, students.size())
		.forEach(i -> {
			String key = students.get(i).name;
			int count = students.stream().filter(x -> x.getName() == key).mapToInt(x->x.getGrade()).sum();
			sameNameAndGrade.put(key, count);
		});
    	
    	String nameAge = Collections.max(sameNameAndAge.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    	String nameGrade = Collections.max(sameNameAndGrade.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    	
    	System.out.println("7. Age Same Name ==> " + nameAge + " / Grade Same Name ==> " + nameGrade);
    	
    }

}