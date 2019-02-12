package study_20190212;

public class Child extends Parent{
	 private String m2;
	 
	 public static class ChildBuilder<ChildBuilder> extends ParentBuilder<ChildBuilder> {
			 private String m2;
			 
			 protected ChildBuilder self() { return (ChildBuilder) this; }
			 
			 public ChildBuilder m2(String m2) {
				 this.m2 = m2;
				 return self();
			 }
			 
		 public Parent build() {
			 Child child = new Child();
			 setValues(child);
			 child.m2 = this.m2;
			 return child;
		 }

	 }
}
