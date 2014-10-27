package oct22;

import static org.junit.Assert.*;

import org.junit.Test;


public class ArgumenstGaloreTest {

	@Test
	public void interLeaveTest() {
		ArgumentsGalore test = new ArgumentsGalore();
		assertTrue("adbecf" == test.interleave("abc", "def"));
	}
}
