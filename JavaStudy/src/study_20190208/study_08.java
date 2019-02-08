package study_20190208;


class study_08 {
	private String value;
	
	public synchronized void offer(String value) {
		while (this.value != null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("offer: " + value);
		this.value = value;
		notifyAll();
	}
	
	public synchronized String take() {
		while (value == null) {
			try {
				wait();
			} catch (InterruptedException e) {}
		}
		System.out.println("take : " + value);
		String ret = value;
		value = null;
		notify();
		return ret; 
	}
	
	
	public static void main(String[] args) {
		study_08 c = new study_08();
		 
		 Runnable producer = () -> {
			 for (int i = 0; i < 10; i++) c.offer(Integer.toString(i));
			 c.offer("done");
		 };
		 
		 Runnable consumer = () -> {
			 boolean done = false;
			 while (!done) {
			 done = "done".equals(c.take()); }
		 };
		 
		 new Thread(producer).start();
		 new Thread(consumer).start();
		}
}