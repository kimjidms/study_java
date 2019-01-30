package study_20190130;

class study_04 {
	
	// 클래스 초기화 블럭
	static { 
		System.out.println("static initialization block");
	}
	
	// 인스턴스 초기화 블럭
	{
		System.out.println("instance initialization block");
	}
	
	study_04() {
		System.out.println("constructor");
	}
	
	public static void main(String[] args) {
		 System.out.println("Before creation instance");
		 new study_04();
		 System.out.println("After creation instance");
	} 
}