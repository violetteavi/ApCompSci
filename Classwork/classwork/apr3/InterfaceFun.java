package apr3;

import static org.junit.Assert.*;

import org.junit.Test;

public class InterfaceFun {

	@Test
	public void countsAdds() {
		CountableNumberList test = new Implementation();
		test.add(-5);
		test.add(3);
		test.add(7);
		test.add(4);
		test.add(6);
		assertEquals(5, test.count());
	}

	@Test
	public void countsSums() {
		CountableNumberList test = new Implementation();
		test.add(-5);
		test.add(3);
		test.add(7);
		test.add(4);
		test.add(6);
		assertEquals(15, test.sum(), 0.00001);
	}

	@Test
	public void countsPrints() {
		Implementation test = new Implementation();
		test.add(-5);
		test.add(3);
		test.add(7);
		test.add(4);
		test.add(6);
		System.out.println(test.toString());
	}
}
