package testingMenùManager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.MenùBean;
import model.MenùManager;
import model.PrenotazioneBean;

public class TestMMgetMenùs {
	
	@Before
	public void setUp() {
		menu = new ArrayList<MenùBean>();
	}
	
	@Test
	public void getMenusTest() {
		menu = mm.getMenùs();
		assertEquals(true, mm.getMenùs().size() > 0);
	}
	
	
	@After
	public void tearDown() {
		menu = null;
	}
	
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testForException() {
		Object o = menu.get(0);
	}
	
	
	private ArrayList<MenùBean> menu;
	private MenùManager mm = new MenùManager();
}
