package oct2;

import static org.junit.Assert.*;

import org.junit.Test;


public class JobTrackerTest {

	@Test
	public void test() {
		double totalHours = JobTracker.sumHours(5.0, 5.0, 5.0, 2.5, 2.5);
		assertEquals(20.0, totalHours, 0.001);
		double gross = JobTracker.gross(totalHours);
		assertEquals(250, gross, 0.001);
		double afterTax = JobTracker.accountForTax(gross);
		assertEquals(182.5, afterTax, 0.001);
		assertEquals(182.5, JobTracker.calcIncome(5.0, 5.0, 5.0, 2.5, 2.5), 0.001);
	}
}
