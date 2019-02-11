package study_20190211;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockTest {
	@Test
	public void Test() {
		
		List<String> list = mock(List.class);
		
		when(list.size()).thenReturn(100);
		when(list.get(0)).thenReturn("Hello");
		
		assertEquals(100, list.size());
		assertEquals("Hello", list.get(0));
		
		verify(list).size();
		verify(list).get(1);
	}
	
	static class C {
		 private List<String> list;
		 C(List<String> list) { this.list = list; }
	}
	
	@Mock private List<String> list;
	@InjectMocks C c; // new C(list) 효과
	@Before public void setUp() {
		MockitoAnnotations.initMocks(this);
		when(list.get(0)).thenReturn("OK");
	}
	
	@Test public void test() {
		assertEquals("OK", c.list.get(0));
	}
		
}
