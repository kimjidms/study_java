package 김은지_ch13;

public class Student {
	
    int age = 0;
	int grade = 0;
	String genders = "";
	String name = "";
	 
	public Student() {}

	public Student(int age, int grade, String genders, String name) {
	     this.age = age;
    	 this.grade = grade;
    	 this.genders = genders;
    	 this.name = name;
	};

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getGender() {
		return genders;
	}

	public void setGender(String gender) {
		this.genders = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
