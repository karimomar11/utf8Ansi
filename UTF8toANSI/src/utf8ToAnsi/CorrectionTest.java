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
		String t2 = "������� ������� �������";
		assertEquals(Correction.correctedCSV(t2), "AeOeUeaeoeuess AeOeUeaeoeuess AeOeUeaeoeuess");
	}

	@After
	public void after() {
		System.out.println("Finish");
		c = null;
	}
}
