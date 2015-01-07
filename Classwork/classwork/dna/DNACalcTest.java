package dna;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DNACalcTest {

	@Test
	public void test() {
		int[] count = {6,4,2,6,2};
		System.out.println(Arrays.toString(DNACalc.getComposition(count)));
	}

}
