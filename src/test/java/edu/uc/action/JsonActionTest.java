package edu.uc.action;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JsonActionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String id = "191a";
		System.out.println(id.substring(0,id.length()-2));
		System.out.println(id.substring(id.length()-1,id.length()));
	}

}
