package utf8ToAnsi;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utf8ToAnsi.Correction;

public class CorrectionTest {
	Correction c;

	@Before
	public void setUp() {
		c = new Correction();
	}

	@Test
	public void test() {
		String t2 = "ÄÖÜäöüß ÄÖÜäöüß ÄÖÜäöüß";
		assertEquals(Correction.correctedCSV(t2), "AeOeUeaeoeuess AeOeUeaeoeuess AeOeUeaeoeuess");
	}

	@Test
	public void testGetText() {
		String t = "AEIOU";
		c.setText(t);
		assertEquals(c.getText(), t);
	}

	@Test
	public void testGetNewName() {
		String t = "AEIOU";
		c.setNewName(t);
		assertEquals(c.getNewName(), t);
	}

	@After
	public void after() {
		System.out.println("Finish");
		c = null;
	}
}
