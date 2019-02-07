package 김은지_ch13;

import java.util.concurrent.ThreadLocalRandom;

class Gender {
	private int genders;
	public Gender() {};
	
	public String getGender() {
		genders = ThreadLocalRandom.current().nextInt(0, 2);
		if(genders == 0) {
			return "MALE";
		} else {
			return "FEMALE";
		}
	}
}
