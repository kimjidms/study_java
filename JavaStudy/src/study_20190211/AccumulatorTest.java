package study_20190211;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

public class AccumulatorTest {
	 @Test
	 public void testSum() {
		 Accumulator acc = new Accumulator();
		 int sum = acc.sum(1, 2, 3);
		 assertEquals(6, sum);
	 }
 
    public @Test void testAssertArrayEquals() {
		 int[] expected = { 1, 2, 3 };
		 int[] actual = { 2, 3, 4 };
		 assertArrayEquals("Array not equals", expected, actual);
	}
 
	public @Test void testAssertEquals() {
		 assertEquals(1, 1);
		 assertNotSame(new String("test"), new String("test"));
	}
	
	public @Test void testAssertNotNull() {
		 Object obj = null;
		 assertNotNull("obj is null", obj);
	}
	
	public @Test void testAssertFalse() {
		assertFalse(true);
	}
	
	public @Test void testFail() {
		fail("This is failure");
	} 
	
	@Test
	public void testAssertThat() {
		List<String> actual = Arrays.asList("Hello", "world");
		assertThat(actual, CoreMatchers.hasItem("Hello"));
	} 

	public @Test void testThrown1() throws Exception {
		 try {
			 throw new Exception();
			// fail("예외 발생 안함"); // 에러 무시하기 
		 } catch (Exception e) {
			 // OK
		 }
	}
		
	@Test(expected = Exception.class)
	public void testThrown2() throws Exception {
		throw new Exception();
	}
	// org.junit.rules.ExpectedException
	public @Rule ExpectedException thrown = ExpectedException.none();
	public @Test void testThrow3() throws IOException {
		thrown.expect(IOException.class);
		thrown.expectMessage(CoreMatchers.containsString("test"));
		throw new IOException("test message");
	}
		
		
	@BeforeClass public static void setUpClass() {
		System.out.println("BeforeClass");
	}
	@AfterClass public static void tearDownClass() {
		System.out.println("AfterClass");
	}
	@Before public void setUp() { 
		System.out.println("Before"); 
		}
	@After public void tearDown() { 
		System.out.println("After"); 
	}
	@Test public void test1() { 
		System.out.println("test1");
	}
	@Test public void test2() { 
		System.out.println("test2"); 
	}
		
}


