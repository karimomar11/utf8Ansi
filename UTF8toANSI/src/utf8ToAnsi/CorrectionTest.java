package utf8ToAnsi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class CorrectionTest {
	
	@Test
	public void test() {
		String t2="ÄÖÜäöüß ÄÖÜäöüß ÄÖÜäöüß";
		assertEquals(Correction.correctedCSV(t2),"AeOeUeaeoeuess AeOeUeaeoeuess AeOeUeaeoeuess");
	}
	

	@After
	public void after() {
		System.out.println("Finish");
	}

}
