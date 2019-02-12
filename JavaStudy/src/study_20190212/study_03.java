package study_20190212;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class study_03 {
	public class Flyweight {
		private String value;
		public Flyweight(String value) { this.value = value; }
	}
	
	public class FlyweightFactory {
		private static final Map<String, Flyweight> CACHE = new ConcurrentHashMap<>();
		
		public static Flyweight getFlyweight(String value) {
			return CACHE.computeIfAbsent(value, // get for value
			v -> new Flyweight(v)); // if value doesn't exist
		}
	}
	
	public class Client {
		void method() {
			Flyweight a1 = FlyweightFactory.getFlyweight("a");
			Flyweight a2 = FlyweightFactory.getFlyweight("a");
			System.out.println(a1 == a2);
		}
	}
}
