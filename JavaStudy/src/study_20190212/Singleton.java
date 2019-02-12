package study_20190212;

// Singleton
public class Singleton {
	static { System.out.println("Singleton class loaded"); }
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		System.out.println("Singleton.getInstance()");
		return LazyHolder.INSTANCE;
	}
	private static class LazyHolder {
		static { System.out.println("LazyHolder class loaded"); }
		private static final Singleton INSTANCE = new Singleton();
	}

}

