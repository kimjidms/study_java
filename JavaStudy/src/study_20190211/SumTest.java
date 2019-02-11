package study_20190211;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*; 

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExternalResource;
import org.junit.rules.RuleChain;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumTest {
	@Parameters
	 public static Iterable<Object[]> data() {
		 return Arrays.asList(new Object[][] {
			 { 0, 1, 1 }, { 1, 1, 2 }, { 2, -1, 1 }, { 3, 3, 7 }
		 });
	 }

	 @Parameter public int i; // @Parameter(0)
	 @Parameter(1) public int j;
	 @Parameter(2) public int expected; 
	 
	 @Test public void test() {
		 assertEquals(expected, i + j);
	 } 
	 
	 @Parameters(name = "{index}: {0} + {1} => {2}")
	 public static Iterable<Object[]> data1() {
		 return Arrays.asList(new Object[][] {
			 { 0, 1, 1 }, { 1, 1, 2 }, { 2, -1, 1 }, { 3, 3, 7 }
	    });
	 }
	 
	 public @Rule TemporaryFolder tempFolder = new TemporaryFolder();
	 public @Test void test1() throws IOException {
		 File folder = tempFolder.newFolder();
	  	 File file = tempFolder.newFile();
	  	 System.out.println(file.getCanonicalPath());
	 }
	 
	 
	 public @Rule ErrorCollector collector = new ErrorCollector();
	 public @Test void test2() {
		 collector.addError(new Exception("error 1"));
		 collector.addError(new Exception("error 2"));
	 }
	 
	 class Logging extends ExternalResource{
			private final String name;
			Logging(String name) { this.name = name; }
			 protected void before() { System.out.println(name + ": before"); }
			 protected void after() { System.out.println(name + ": after"); } 
	}

	@Rule
	public RuleChain chain = RuleChain
		.outerRule(new Logging("outer"))
		.around(new Logging("inner1"))
		.around(new Logging("inner2"));
	
	@Test
		public void test3() {
		System.out.println("test");
	}
}	