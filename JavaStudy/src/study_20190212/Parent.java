package study_20190212;

public abstract class Parent {
	 private String m1;
	 
	 public abstract static class ParentBuilder<T extends ParentBuilder<T>> {
		private String m1;
	    protected abstract T self();
		public T m1(String m1) {
			this.m1 = m1;
			return self();
		 }
			 
		 protected void setValues(Parent parent) {
			 parent.m1 = this.m1;
		 }
	 } 
}
